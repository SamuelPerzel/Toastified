package samuelperzel.toastified.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import samuelperzel.toastified.Toastified;

public class ModItems {
    public static final Item RAW_SPECTRALITE = registerItem("raw_spectralite",
            new Item(new FabricItemSettings()));
    public static final Item SPECTRALITE_CRYSTAL = registerItem("spectralite_crystal",
            new Item(new FabricItemSettings()));

    public static final Item PULVERIZED_SPECTRALITE = registerItem("pulverized_spectralite",
            new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Toastified.MOD_ID, name), item);
    }

    public static final Item SPECTRALITE_BAR = registerItem("spectralite_bar",
            new Item(new FabricItemSettings()));

    public static void addItemsToItemGroup() {
        addToItemGroup(ModItemGroup.TOASTIFIED, RAW_SPECTRALITE);
        addToItemGroup(ModItemGroup.TOASTIFIED, SPECTRALITE_CRYSTAL);
        addToItemGroup(ModItemGroup.TOASTIFIED, PULVERIZED_SPECTRALITE);
        addToItemGroup(ModItemGroup.TOASTIFIED, SPECTRALITE_BAR);
    }
    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerItems() {
        Toastified.LOGGER.info("Registering Mod Items for " + Toastified.MOD_ID);

        addItemsToItemGroup();
    }
}
