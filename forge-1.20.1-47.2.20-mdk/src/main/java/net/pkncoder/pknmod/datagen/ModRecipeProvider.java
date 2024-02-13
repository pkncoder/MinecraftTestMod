package net.pkncoder.pknmod.datagen;

import net.pkncoder.pknmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    private static final List<ItemLike> CHILD_SMELTABLES = List.of(ModItems.CHILD.get());


    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        oreBlasting(pWriter, CHILD_SMELTABLES, RecipeCategory.MISC, ModItems.FLAMING_CHILD.get(), 0.25f, 10, "child");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CHILD.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', Items.NETHERITE_BLOCK)
                .unlockedBy(getHasName(Items.NETHERITE_BLOCK), has(ModItems.CHILD.get()))
                .save(pWriter);
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }
}