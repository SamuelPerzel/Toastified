package samuelperzel.toastified.block;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

public class ModFlammableBlockRegistry {
    public static void registerFlammableBlocks() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        registry.add(ModBlocks.GLOWRAY_LOG, 5, 5);
        registry.add(ModBlocks.GLOWRAY_WOOD, 5, 5);
        registry.add(ModBlocks.STRIPPED_GLOWRAY_LOG, 5, 5);
        registry.add(ModBlocks.STRIPPED_GLOWRAY_WOOD, 5, 5);
        registry.add(ModBlocks.GLOWRAY_PLANKS, 5, 20);
        registry.add(ModBlocks.GLOWRAY_LEAVES, 30, 60);
        registry.add(ModBlocks.GLOWRAY_SAPLING, 5, 20);
    }
}
