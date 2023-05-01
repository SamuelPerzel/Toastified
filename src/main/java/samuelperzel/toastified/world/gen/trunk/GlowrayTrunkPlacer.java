package samuelperzel.toastified.world.gen.trunk;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import samuelperzel.toastified.Toastified;

import java.util.List;
import java.util.function.BiConsumer;

public class GlowrayTrunkPlacer extends TrunkPlacer {
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
        setToDirt(world, replacer, random, startPos.down(), config);

        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for (int i = 0; i < height; i++) {
            this.setLog(world, replacer, random, mutable, config, startPos, 0, i, 0);
        }

        return ImmutableList.of(new FoliagePlacer.TreeNode(startPos.up(height - 2), 0, false));
    }

    private void setLog(TestableWorld testableWorld, BiConsumer<BlockPos, BlockState> biConsumer, Random random, BlockPos.Mutable mutable, TreeFeatureConfig treeFeatureConfig, BlockPos blockPos, int x, int y, int z) {
        mutable.set(blockPos, x, y, z);
        this.trySetState(testableWorld, biConsumer, random, mutable, treeFeatureConfig);
    }
}
