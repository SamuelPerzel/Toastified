package samuelperzel.toastified.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import samuelperzel.toastified.Toastified;

public class ModItemGroup {
    public static ItemGroup TOASTIFIED;

    public static void registerItemGroups() {
        TOASTIFIED = FabricItemGroup.builder(new Identifier(Toastified.MOD_ID, "toastified"))
                .displayName(Text.literal("Toastified Mod"))
                .icon(() -> new ItemStack(ModItems.SPECTRALITE_CRYSTAL))
                .build();
    }
}
