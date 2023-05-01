package samuelperzel.toastified.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import samuelperzel.toastified.world.biome.ModBiomes;
import samuelperzel.toastified.world.tree.ModPlacedFeatures;

public class ModTreeGeneration {
    public static void generateTrees() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.GLOWRAY_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.GLOWRAY_PLACED_KEY);
    }
}
