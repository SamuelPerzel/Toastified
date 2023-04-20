package samuelperzel.toastified.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import samuelperzel.toastified.block.ModBlocks;
import samuelperzel.toastified.fluid.ModFluids;
import samuelperzel.toastified.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        // ----------------------------------------------------------------------------------------------------
        // BLOCKS
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.STEEL_BLOCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SPECTRALITE_BLOCK);
        // ----------------------------------------------------------------------------------------------------
        // ORES
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SPECTRALITE_ORE);
        // ----------------------------------------------------------------------------------------------------
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // ----------------------------------------------------------------------------------------------------
        // ITEMS
        // steel
        itemModelGenerator.register(ModItems.STEEL_INGOT, Models.GENERATED);
        // crystalite
        itemModelGenerator.register(ModItems.RAW_SPECTRALITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPECTRALITE_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.PULVERIZED_SPECTRALITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPECTRALITE_INGOT, Models.GENERATED);
        // ----------------------------------------------------------------------------------------------------
        // FLUIDS
        itemModelGenerator.register(ModFluids.LIQUIFIED_LIGHT_BUCKET, Models.GENERATED);
        // ----------------------------------------------------------------------------------------------------
    }
}
