package samuelperzel.toastified;

import net.fabricmc.api.ModInitializer;

import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import samuelperzel.toastified.block.ModBlocks;
import samuelperzel.toastified.fluid.ModFluids;
import samuelperzel.toastified.item.ModItemGroup;
import samuelperzel.toastified.item.ModItems;
import samuelperzel.toastified.world.biome.ModSurfaceRuleData;
import samuelperzel.toastified.world.region.ModRegionCrystalline;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class Toastified implements ModInitializer, TerraBlenderApi {
	public static final String MOD_ID = "toastified";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// item related
		ModItemGroup.registerItemGroups();
		ModBlocks.registerModBocks();
		ModItems.registerItems();
		ModFluids.registerFluids();

		// biomes
	}

	@Override
	public void onTerraBlenderInitialized() {
		Regions.register(new ModRegionCrystalline(new Identifier(Toastified.MOD_ID), 8));

		SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, Toastified.MOD_ID, ModSurfaceRuleData.makeRules());
	}
}