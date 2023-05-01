package samuelperzel.toastified.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.item.Items;
import samuelperzel.toastified.block.ModBlocks;
import samuelperzel.toastified.item.ModItems;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.SPECTRALITE_ORE, oreDrops(ModBlocks.SPECTRALITE_ORE, ModItems.RAW_SPECTRALITE));

        addDrop(ModBlocks.STEEL_BLOCK);
        addDrop(ModBlocks.SPECTRALITE_BLOCK);

        addDrop(ModBlocks.GLOWRAY_LOG);
        addDrop(ModBlocks.GLOWRAY_WOOD);
        addDrop(ModBlocks.STRIPPED_GLOWRAY_LOG);
        addDrop(ModBlocks.STRIPPED_GLOWRAY_WOOD);
        leavesDrops(ModBlocks.GLOWRAY_LEAVES, ModBlocks.GLOWRAY_SAPLING, 0.05f);
        addDrop(ModBlocks.GLOWRAY_PLANKS);
        addDrop(ModBlocks.GLOWRAY_SAPLING);
    }
}
