package samuelperzel.toastified.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.CherryFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import samuelperzel.toastified.Toastified;
import samuelperzel.toastified.block.ModBlocks;
import samuelperzel.toastified.world.gen.trunk.GlowrayTrunkPlacer;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> GLOWRAY_TREE = registerKey("glowray_tree");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        register(context, GLOWRAY_TREE, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.GLOWRAY_WOOD),
                new GlowrayTrunkPlacer(32, 0, 0),
                BlockStateProvider.of(ModBlocks.GLOWRAY_LEAVES),
                new CherryFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0),ConstantIntProvider.create(4), 0.1f, 0.5f, 0.5f, 0.75f),
                new TwoLayersFeatureSize(1, 5, 12)).build());
    }

    public static RegistryKey<ConfiguredFeature<?, ?>>  registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Toastified.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
