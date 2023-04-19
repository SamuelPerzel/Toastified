package samuelperzel.toastified.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import samuelperzel.toastified.Toastified;
import samuelperzel.toastified.block.ModBlocks;

public class ModItemGroup {
    public static ItemGroup TOASTIFIED_ITEMS;
    public static ItemGroup TOASTIFIED_BLOCKS;
    public static ItemGroup TOASTIFIED_ORES;
    public static ItemGroup TOASTIFIED_TOOLS;
    public static ItemGroup TOASTIFIED_COMBAT;

    public static void registerItemGroups() {
        TOASTIFIED_ITEMS = FabricItemGroup.builder(new Identifier(Toastified.MOD_ID, "toastified_items"))
                .displayName(Text.literal("Toastified Items"))
                .icon(() -> new ItemStack(ModItems.SPECTRALITE_CRYSTAL))
                .build();

        TOASTIFIED_BLOCKS = FabricItemGroup.builder(new Identifier(Toastified.MOD_ID, "toastified_blocks"))
                .displayName(Text.literal("Toastified Blocks"))
                .icon(() -> new ItemStack(ModBlocks.SPECTRALITE_BLOCK))
                .build();

        TOASTIFIED_ORES = FabricItemGroup.builder(new Identifier(Toastified.MOD_ID, "toastified_ores"))
                .displayName(Text.literal("Toastified Ores"))
                .icon(() -> new ItemStack(ModItems.RAW_SPECTRALITE))
                .build();

        TOASTIFIED_TOOLS = FabricItemGroup.builder(new Identifier(Toastified.MOD_ID, "toastified_tools"))
                .displayName(Text.literal("Toastified Tools"))
                .icon(() -> new ItemStack(ModItems.SPECTRALITE_CRYSTAL))
                .build();

        TOASTIFIED_COMBAT = FabricItemGroup.builder(new Identifier(Toastified.MOD_ID, "toastified_combat"))
                .displayName(Text.literal("Toastified Combat"))
                .icon(() -> new ItemStack(ModItems.SPECTRALITE_CRYSTAL))
                .build();
    }
}
