package samuelperzel.toastified.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import samuelperzel.toastified.block.ModBlocks;
import samuelperzel.toastified.fluid.ModFluids;
import samuelperzel.toastified.item.ModItems;

import java.nio.file.Path;

public class ModEnglishLangProvider extends FabricLanguageProvider {
    public ModEnglishLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        // ----------------------------------------------------------------------------------------------------
        // ITEMS
        // steel
        translationBuilder.add(ModItems.STEEL_INGOT, "Steel Ingot");
        // spectralite
        translationBuilder.add(ModItems.RAW_SPECTRALITE, "Raw Spectralite");
        translationBuilder.add(ModItems.SPECTRALITE_CRYSTAL, "Spectralite Crystal");
        translationBuilder.add(ModItems.PULVERIZED_SPECTRALITE, "Pulverized Spectralite");
        translationBuilder.add(ModItems.SPECTRALITE_INGOT, "Spectralite Ingot");
        // liquids
        translationBuilder.add(ModFluids.LIQUIFIED_LIGHT_BUCKET, "Bucket of Liquified Light");
        // ----------------------------------------------------------------------------------------------------
        // BLOCKS
        // steel
        translationBuilder.add(ModBlocks.STEEL_BLOCK, "Steel Block");
        // spectralite
        translationBuilder.add(ModBlocks.SPECTRALITE_ORE, "Spectralite Ore");
        translationBuilder.add(ModBlocks.SPECTRALITE_BLOCK, "Spectralite Block");
        // ----------------------------------------------------------------------------------------------------

        try {
            Path existingFilePath = dataOutput.getModContainer().findPath("assets/toastified/lang/en_us_existing.json").get();
            translationBuilder.add(existingFilePath);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add existing language file!", e);
        }
    }
}
