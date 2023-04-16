package samuelperzel.toastified.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import samuelperzel.toastified.block.ModBlocks;
import samuelperzel.toastified.item.ModItems;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.SPECTRALITE_ORE, oreDrops(ModBlocks.SPECTRALITE_ORE, ModItems.RAW_SPECTRALITE));

        addDrop(ModBlocks.SPECTRALITE_BLOCK);
    }
}
