package samuelperzel.toastified.world.biome;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import net.minecraft.world.gen.surfacebuilder.MaterialRules.MaterialRule;

public class ModSurfaceRuleData {
    private static final MaterialRule GRASS_BLOCK = makeBlockRule(Blocks.GRASS_BLOCK);
    private static final MaterialRule STONE = makeBlockRule(Blocks.STONE);

    public static MaterialRule makeRules()
    {
        final MaterialRule CRYSTAL_FIELDS_RULES = MaterialRules.sequence(
                MaterialRules.condition(MaterialRules.stoneDepth(0,false, VerticalSurfaceType.FLOOR), GRASS_BLOCK),
                MaterialRules.condition(MaterialRules.surface(), STONE)
        );

        return MaterialRules.sequence(
            MaterialRules.condition(MaterialRules.biome(ModBiomes.CRYSTAl_FIELDS), CRYSTAL_FIELDS_RULES)
        );
    }

    private static MaterialRule makeBlockRule(Block block)
    {
        return MaterialRules.block(block.getDefaultState());
    }
}
