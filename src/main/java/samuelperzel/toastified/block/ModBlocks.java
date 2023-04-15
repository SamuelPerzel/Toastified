package samuelperzel.toastified.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import samuelperzel.toastified.Toastified;
import samuelperzel.toastified.item.ModItemGroup;

public class ModBlocks {
    public static final Block SPECTRALITE_ORE = registerBlock("spectralite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE)
            .strength(10.0f)
            .requiresTool(),
            UniformIntProvider.create(6, 8)),
            ModItemGroup.TOASTIFIED);

    public static final Block SPECTRALITE_BLOCK = registerBlock("spectralite_block",
            new Block(FabricBlockSettings.of(Material.AMETHYST)
            .strength(10.0f)
            .requiresTool()),
            ModItemGroup.TOASTIFIED);

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(Toastified.MOD_ID, name), block);
    }

    public static Item registerBlockItem(String name, Block block, ItemGroup group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(Toastified.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));

        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }

    public static void registerModBocks() {
        Toastified.LOGGER.info("Registering blocks for " + Toastified.MOD_ID);
    }
}
