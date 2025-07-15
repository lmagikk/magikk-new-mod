package net.lmagikk.breachesoflife.datagen;

import net.lmagikk.breachesoflife.BreachesOfLife;
import net.lmagikk.breachesoflife.block.ModBlocks;
import net.lmagikk.breachesoflife.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {


    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        List<ItemLike> ODD_SMELTABLES = List.of(ModItems.ODD_SCRAPS,
                ModBlocks.ODD_ORE, ModBlocks.DEEPSLATE_ODD_ORE);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ODD_BLOCK.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ModItems.ODD_BAR.get())
                .unlockedBy("has_odd_bar", has(ModItems.ODD_BAR.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ODD_BAR.get(), 9)
                .requires(ModBlocks.ODD_BLOCK.asItem())
                .unlockedBy("has_odd_block", has(ModBlocks.ODD_BLOCK.get())).save(recipeOutput);

        oreSmelting(recipeOutput, ODD_SMELTABLES, RecipeCategory.MISC, ModItems.ODD_BAR.get(), 0.25f, 200, "odd");
        oreBlasting(recipeOutput, ODD_SMELTABLES, RecipeCategory.MISC, ModItems.ODD_BAR.get(), 0.25f, 100, "odd");

    }


    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, BreachesOfLife.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
