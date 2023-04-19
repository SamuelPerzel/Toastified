package samuelperzel.toastified.fluid;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import samuelperzel.toastified.Toastified;
import samuelperzel.toastified.item.ModItemGroup;

public class ModFluids {
    public static FlowableFluid STILL_LIQUIFIED_LIGHT;
    public static FlowableFluid FLOWING_LIQUIFIED_LIGHT;
    public static Block LIQUIFIED_LIGHT_BLOCK;
    public static Item LIQUIFIED_LIGHT_BUCKET;

    public static void register() {
        STILL_LIQUIFIED_LIGHT = Registry.register(Registries.FLUID, new Identifier(Toastified.MOD_ID, "liquified_light"), new LiquifiedLightFluid.Still());
        FLOWING_LIQUIFIED_LIGHT = Registry.register(Registries.FLUID, new Identifier(Toastified.MOD_ID, "flowing_liquified_light"), new LiquifiedLightFluid.Flowing());

        LIQUIFIED_LIGHT_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Toastified.MOD_ID, "liquified_light_block"), new FluidBlock(ModFluids.STILL_LIQUIFIED_LIGHT, FabricBlockSettings.copyOf(Blocks.WATER)){ });
        LIQUIFIED_LIGHT_BUCKET = Registry.register(Registries.ITEM, new Identifier(Toastified.MOD_ID, "liquified_light_bucket"), new BucketItem(ModFluids.STILL_LIQUIFIED_LIGHT, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));
    }

    public static void addFluidsToItemGroup() {
        addToItemGroup(ModItemGroup.TOASTIFIED_ITEMS, LIQUIFIED_LIGHT_BUCKET);
    }
    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerFluids() {
        Toastified.LOGGER.info("Registering fluids for " + Toastified.MOD_ID);

        register();
        addFluidsToItemGroup();
    }
}
