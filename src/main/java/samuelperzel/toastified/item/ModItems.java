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
    // ----------------------------------------------------------------------------------------------------
    // steel
    public static final Item STEEL_INGOT = registerItem("steel_ingot",
            new Item(new FabricItemSettings()));
    // ----------------------------------------------------------------------------------------------------
    // spectralite
    public static final Item RAW_SPECTRALITE = registerItem("raw_spectralite",
            new Item(new FabricItemSettings()));
    public static final Item SPECTRALITE_CRYSTAL = registerItem("spectralite_crystal",
            new Item(new FabricItemSettings()));

    public static final Item PULVERIZED_SPECTRALITE = registerItem("pulverized_spectralite",
            new Item(new FabricItemSettings()));

    public static final Item SPECTRALITE_INGOT = registerItem("spectralite_ingot",
            new Item(new FabricItemSettings()));
    // ----------------------------------------------------------------------------------------------------

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Toastified.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {
        // ----------------------------------------------------------------------------------------------------
        // ITEMS
        // steel
        addToItemGroup(ModItemGroup.TOASTIFIED_ITEMS, STEEL_INGOT);
        // spectralite
        addToItemGroup(ModItemGroup.TOASTIFIED_ITEMS, SPECTRALITE_CRYSTAL);
        addToItemGroup(ModItemGroup.TOASTIFIED_ITEMS, PULVERIZED_SPECTRALITE);
        addToItemGroup(ModItemGroup.TOASTIFIED_ITEMS, SPECTRALITE_INGOT);
        // ----------------------------------------------------------------------------------------------------
        // ORES
        addToItemGroup(ModItemGroup.TOASTIFIED_ORES, RAW_SPECTRALITE);
        // ----------------------------------------------------------------------------------------------------
        // TOOLS
        // ----------------------------------------------------------------------------------------------------
        // COMBAT
        // ----------------------------------------------------------------------------------------------------
    }
    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerItems() {
        Toastified.LOGGER.info("Registering Mod Items for " + Toastified.MOD_ID);

        addItemsToItemGroup();
    }
}
