package samuelperzel.toastified.block;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class ModStrippableBlockRegistry {
    public static void registerStrippableBlocks() {
        StrippableBlockRegistry.register(ModBlocks.GLOWRAY_LOG, ModBlocks.STRIPPED_GLOWRAY_LOG);
        StrippableBlockRegistry.register(ModBlocks.GLOWRAY_WOOD, ModBlocks.STRIPPED_GLOWRAY_WOOD);
    }
}
