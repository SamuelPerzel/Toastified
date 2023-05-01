package samuelperzel.toastified.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import samuelperzel.toastified.Toastified;
import samuelperzel.toastified.item.ModItemGroup;
import samuelperzel.toastified.world.tree.GlowraySaplingGenerator;

public class ModBlocks {
    // ----------------------------------------------------------------------------------------------------
    // steel
    public static final Block STEEL_BLOCK = registerBlock("steel_block",
            new Block(FabricBlockSettings.of(Material.METAL)
            .strength(5.0f)
            .requiresTool()
            .sounds(BlockSoundGroup.METAL)),
            ModItemGroup.TOASTIFIED_ORES);

    // spectralite
    public static final Block SPECTRALITE_ORE = registerBlock("spectralite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE)
            .strength(50.0f)
            .requiresTool()
            .luminance(10)
            .sounds(BlockSoundGroup.STONE),
            UniformIntProvider.create(6, 8)),
            ModItemGroup.TOASTIFIED_ORES);

    public static final Block SPECTRALITE_BLOCK = registerBlock("spectralite_block",
            new Block(FabricBlockSettings.of(Material.AMETHYST)
            .strength(25.0f)
            .requiresTool()
            .luminance(15)
            .sounds(BlockSoundGroup.AMETHYST_BLOCK)),
            ModItemGroup.TOASTIFIED_BLOCKS);

    // glowray wood
    public static final Block GLOWRAY_LOG = registerBlock("glowray_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)), ModItemGroup.TOASTIFIED_BLOCKS);

    public static final Block GLOWRAY_WOOD = registerBlock("glowray_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)), ModItemGroup.TOASTIFIED_BLOCKS);

    public static final Block STRIPPED_GLOWRAY_LOG = registerBlock("stripped_glowray_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)), ModItemGroup.TOASTIFIED_BLOCKS);

    public static final Block STRIPPED_GLOWRAY_WOOD = registerBlock("stripped_glowray_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)), ModItemGroup.TOASTIFIED_BLOCKS);

    public static final Block GLOWRAY_LEAVES = registerBlock("glowray_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)), ModItemGroup.TOASTIFIED_BLOCKS);

    public static final Block GLOWRAY_PLANKS = registerBlock("glowray_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)), ModItemGroup.TOASTIFIED_BLOCKS);

    public static final Block GLOWRAY_SAPLING = registerBlock("glowray_sapling",
            new SaplingBlock(new GlowraySaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)), ModItemGroup.TOASTIFIED_BLOCKS);
    // ----------------------------------------------------------------------------------------------------

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
