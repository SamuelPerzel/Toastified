package samuelperzel.toastified.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import samuelperzel.toastified.block.ModBlocks;
import samuelperzel.toastified.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        // smelting
        offerSmelting(exporter, List.of(Items.IRON_INGOT), RecipeCategory.MISC, ModItems.STEEL_INGOT, 1f, 200, "steel");
        offerSmelting(exporter, List.of(Blocks.IRON_BLOCK), RecipeCategory.MISC, ModBlocks.STEEL_BLOCK, 9*1f, 9*200, "steel");

        // blasting
        offerBlasting(exporter, List.of(Items.IRON_INGOT), RecipeCategory.MISC, ModItems.STEEL_INGOT, 1f, 100, "steel");
        offerBlasting(exporter, List.of(Blocks.IRON_BLOCK), RecipeCategory.MISC, ModBlocks.STEEL_BLOCK, 9*1f, 9*100, "steel");

        // reversible craftings
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.STEEL_INGOT, RecipeCategory.MISC, ModBlocks.STEEL_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.SPECTRALITE_CRYSTAL, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SPECTRALITE_BLOCK);
    }
}
