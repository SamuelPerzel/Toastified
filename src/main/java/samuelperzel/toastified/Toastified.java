package samuelperzel.toastified;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import samuelperzel.toastified.block.ModBlocks;
import samuelperzel.toastified.item.ModItemGroup;
import samuelperzel.toastified.item.ModItems;

public class Toastified implements ModInitializer {
	public static final String MOD_ID = "toastified";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();
		ModBlocks.registerModBocks();
		ModItems.registerItems();
	}
}