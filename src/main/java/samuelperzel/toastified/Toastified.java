package samuelperzel.toastified;

import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import samuelperzel.toastified.block.ModBlocks;
import samuelperzel.toastified.block.ModFlammableBlockRegistry;
import samuelperzel.toastified.block.ModStrippableBlockRegistry;
import samuelperzel.toastified.fluid.ModFluids;
import samuelperzel.toastified.item.ModItemGroup;
import samuelperzel.toastified.item.ModItems;
import samuelperzel.toastified.mixin.TrunkPlacerTypeInvoker;
import samuelperzel.toastified.world.biome.ModSurfaceRuleData;
import samuelperzel.toastified.world.dimension.ModDimensions;
import samuelperzel.toastified.world.gen.ModWorldGeneration;
import samuelperzel.toastified.world.gen.trunk.GlowrayTrunkPlacer;
import samuelperzel.toastified.world.region.ModRegionGlowrayForest;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class Toastified implements ModInitializer, TerraBlenderApi {
	public static final String MOD_ID = "toastified";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final TrunkPlacerType<GlowrayTrunkPlacer> GLOWRAY_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("toastified:glowray_trunk_placer", GlowrayTrunkPlacer.CODEC);

	@Override
	public void onInitialize() {
		// item related
		ModItemGroup.registerItemGroups();
		ModBlocks.registerModBocks();
		ModItems.registerItems();
		ModFluids.registerFluids();

		ModFlammableBlockRegistry.registerFlammableBlocks();
		ModStrippableBlockRegistry.registerStrippableBlocks();

		ModWorldGeneration.generateWorldGen();

		ModDimensions.registerDimensions();
	}

	@Override
	public void onTerraBlenderInitialized() {
		Regions.register(new ModRegionGlowrayForest(new Identifier(Toastified.MOD_ID), 8));

		SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, Toastified.MOD_ID, ModSurfaceRuleData.makeRules());
	}
}