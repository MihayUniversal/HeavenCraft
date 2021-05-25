package com.mihayuniversal.heavencraft.data;

import java.util.function.Consumer;

import com.mihayuniversal.heavencraft.init.ModBlocks;
import com.mihayuniversal.heavencraft.init.ModItems;
import com.mihayuniversal.heavencraft.util.Reference;

import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

public class ModRecipeProvider extends RecipeProvider {

	public ModRecipeProvider(DataGenerator gen) {
		super(gen);
	}
	
	@Override
	protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
		ShapelessRecipeBuilder.shapeless(ModItems.ANGEL_INGOT.get(), 9)
	        .requires(ModBlocks.ANGEL_BLOCK.get())
	        .unlockedBy("has_item", has(ModItems.ANGEL_INGOT.get()))
	        .save(consumer);
		
		ShapedRecipeBuilder.shaped(ModBlocks.ANGEL_BLOCK.get())
	    	.define('#', ModItems.ANGEL_INGOT.get())
	    	.pattern("###")
	    	.pattern("###")
	    	.pattern("###")
	    	.unlockedBy("has_item", has(ModItems.ANGEL_INGOT.get()))
	    	.save(consumer);
	
		CookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.ANGEL_ORE.get()), ModItems.ANGEL_INGOT.get(), 0.7f, 200)
        	.unlockedBy("has_item", has(ModBlocks.ANGEL_ORE.get()))
        	.save(consumer, modId("angel_ingot_smelting"));
		
		CookingRecipeBuilder.blasting(Ingredient.of(ModBlocks.ANGEL_ORE.get()), ModItems.ANGEL_INGOT.get(), 0.7f, 100)
		    .unlockedBy("has_item", has(ModBlocks.ANGEL_ORE.get()))
		    .save(consumer, modId("angel_ingot_blasting"));
		
	}
	
	private static ResourceLocation modId(String path) {
        return new ResourceLocation(Reference.MODID, path);
    }
	
}
