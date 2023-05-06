package samuelperzel.toastified.world.gen.trunk;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import samuelperzel.toastified.Toastified;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class GlowrayTrunkPlacer extends TrunkPlacer {
    private TestableWorld testableWorld;
    private BiConsumer<BlockPos, BlockState> biConsumer;
    private Random random;
    private BlockPos.Mutable mutable;
    private TreeFeatureConfig treeFeatureConfig;
    private BlockPos blockPos;
    private ArrayList<FoliagePlacer.TreeNode> treeNodes;

    public static final Codec<GlowrayTrunkPlacer> CODEC = RecordCodecBuilder.create(instance -> fillTrunkPlacerFields(instance).apply(instance, GlowrayTrunkPlacer::new));

    public GlowrayTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return Toastified.GLOWRAY_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        // class variables
        this.testableWorld = world;
        this.biConsumer = replacer;
        this.random = random;
        this.mutable = new BlockPos.Mutable();
        this.treeFeatureConfig = config;
        this.blockPos = startPos;
        this.treeNodes = new ArrayList<>();

        setToDirt(world, replacer, random, startPos.down(), config);

        // generates the tree
        generateTrunk(2*height);
        generateRoots();

        return treeNodes;
    }

    private void generateTrunk(int height) {
        int sideSize = 2;
        float branchChance = 0.002f;
        float diversionChance = 0.25f;
        float ascensionChance = 0.20f;
        int startLength = 3;
        float lengthChange = 0;

        fixBase(sideSize); // fixes the base before the trunk is built

        // builds the trunk
        for (int y = 0; y < height; y++) {
            // generates the 4 sides
            for (int i = -1; i <= 1; i++) {
                setLog(-sideSize, y, i);
                generateBranch(branchChance, diversionChance, ascensionChance, startLength, "west", -sideSize, y, i);
                setLog(sideSize, y, i);
                generateBranch(branchChance, diversionChance, ascensionChance, startLength, "east", sideSize, y, i);
                setLog(i, y, -sideSize);
                generateBranch(branchChance, diversionChance, ascensionChance, startLength, "north", i, y, -sideSize);
                setLog(i, y, sideSize);
                generateBranch(branchChance, diversionChance, ascensionChance, startLength, "south", i, y, sideSize);
            }

            if (lengthChange >= 1) { // the branches get longer and more upwards the more they ascend
                startLength++;
                lengthChange = 0;
                ascensionChance += 0.1f;
                branchChance += 0.004f;
                continue;
            }
            lengthChange += 0.2f;
        }
    }

    private void generateBranch(float chance, float diversionChance, float ascensionChance, int length, String direction, int x, int y, int z) {
        if (Math.random() <= chance && y >= 10) { // if the check passed, the branch will generate
            for (int i = 1; i <= length; i++) { // generates the branch
                float booleanTester = 0.5f;
                if ("north".equals(direction)) {
                    z--;
                    if (x == -1) {
                        diversionChance += 0.2f;
                        booleanTester = 0.2f;
                    }
                    if (x == 1) {
                        diversionChance += 0.2f;
                        booleanTester = 0.8f;
                    }
                    if (Math.random() <= diversionChance) { // if the branch passes the diversion chance
                        if (Math.random() < booleanTester) { // it diverges into one way or the other
                            x++;
                        } else {
                            x--;
                        }
                    }
                }
                if ("east".equals(direction)) {
                    x++;
                    if (x == -1) {
                        diversionChance += 0.2f;
                        booleanTester = 0.8f;
                    }
                    if (x == 1) {
                        diversionChance += 0.2f;
                        booleanTester = 0.2f;
                    }
                    if (Math.random() <= diversionChance) {
                        if (Math.random() < booleanTester) {
                            z++;
                        } else {
                            z--;
                        }
                    }
                }
                if ("west".equals(direction)) {
                    x--;
                    if (x == -1) {
                        diversionChance += 0.2f;
                        booleanTester = 0.2f;
                    }
                    if (x == 1) {
                        diversionChance += 0.2f;
                        booleanTester = 0.8f;
                    }
                    if (Math.random() <= diversionChance) {
                        if (Math.random() < booleanTester) {
                            z++;
                        } else {
                            z--;
                        }
                    }
                }
                if ("south".equals(direction)) {
                    z++;
                    if (x == -1) {
                        diversionChance += 0.2f;
                        booleanTester = 0.8f;
                    }
                    if (x == 1) {
                        diversionChance += 0.2f;
                        booleanTester = 0.2f;
                    }
                    if (Math.random() <= diversionChance) {
                        if (Math.random() < booleanTester) {
                            x++;
                        } else {
                            x--;
                        }
                    }
                }

                if (Math.random() <= ascensionChance) { // ascends the branch
                    y++;
                }

                setLog(x, y, z); // main branch

                // shell (thicker branches look better)
                setLog(x, y + 1, z);
                setLog(x, y - 1, z);
                if ("north".equals(direction) || "south".equals(direction)) {
                    setLog(x + 1, y, z);
                    setLog(x - 1, y, z);
                }
                if ("east".equals(direction) || "west".equals(direction)) {
                    setLog(x, y, z + 1);
                    setLog(x, y, z - 1);
                }

                if (Math.random() < 0.25f){
                    this.treeNodes.add(new FoliagePlacer.TreeNode(getRelativeBlockPos(this.blockPos, x, y + 2, z), 0, true));
                }
            }
        }
    }

    private void generateRoots() {

    }

    private void fixBase(int sideSize) { // makes the base not levitate if generated on an uneven surface (similar to generateTrunk, but this only gets called once)
        // generates the 4 sides
        for (int i = -1; i <= 1; i++) {
            fillDown(-sideSize, i);
            fillDown(sideSize, i);
            fillDown(i, -sideSize);
            fillDown(-i, sideSize);
        }
    }

    private void fillDown (int x, int z) { // fills all the air blocks below the certain block position
        // gets the current blockPos and moves it according to the x and z
        BlockPos currentBlockPos = this.blockPos;
        currentBlockPos = currentBlockPos.east(x);
        currentBlockPos = currentBlockPos.south(z);

        int i = -1;
        while (isAirBelow(currentBlockPos)) {
            setLog(x, i, z);

            currentBlockPos = currentBlockPos.down();
            i--;
        }
    }

    private boolean isAirBelow(BlockPos blockPos) { // checks if there is air below the block position
        Predicate<BlockState> blockStatePredicate = blockState -> blockState.equals(Blocks.AIR.getDefaultState());
        blockStatePredicate = blockStatePredicate.or(blockState -> blockState.equals(Blocks.GRASS.getDefaultState()));
        blockStatePredicate = blockStatePredicate.or(blockState -> blockState.equals(Blocks.TALL_GRASS.getDefaultState()));

        return this.testableWorld.testBlockState(blockPos.down(), blockStatePredicate);
    }

    private BlockPos getRelativeBlockPos(BlockPos pos, int x, int y, int z) {
        pos = pos.east(x);
        pos = pos.up(y);
        pos = pos.south(z);

        return pos;
    }

    // shorter, easier to use, setLog method (calls setLog which actually places logs)
    private void setLog(int x, int y, int z) {
        setLog(this.testableWorld, this.biConsumer, this.random, this.mutable, this.treeFeatureConfig, this.blockPos, x, y, z);
    }

    // longer setLog method (actually sets the log)
    private void setLog(TestableWorld testableWorld, BiConsumer<BlockPos, BlockState> biConsumer, Random random, BlockPos.Mutable mutable, TreeFeatureConfig treeFeatureConfig, BlockPos blockPos, int x, int y, int z) {
        mutable.set(blockPos, x, y, z);
        this.trySetState(testableWorld, biConsumer, random, mutable, treeFeatureConfig);
    }
}
