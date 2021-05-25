package com.mihayuniversal.heavencraft.init;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

import com.mihayuniversal.heavencraft.block.angelfurnace.AngelFurnaceBlock;

//import com.mihayuniversal.heavencraft.BlockAngelBlock;

public class ModBlocks {
	
	public static final RegistryObject<Block> ANGEL_ORE = register("angel_ore", () ->
		new Block(AbstractBlock.Properties.of(Material.STONE).sound(SoundType.STONE).strength(10.0F)
			.requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).harvestLevel(3))
	);
	
	public static final RegistryObject<Block> ANGEL_BLOCK = register("angel_block", () ->
		new Block(AbstractBlock.Properties.of(Material.METAL).sound(SoundType.METAL).strength(12.0F)
			.requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).harvestLevel(3))
	);
	
	public static final RegistryObject<AngelFurnaceBlock> ANGEL_FURNACE = register("angel_furnace", () ->
		new AngelFurnaceBlock(AbstractBlock.Properties.of(Material.METAL).sound(SoundType.METAL).strength(12.0F)
			.requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).harvestLevel(3))
	);
	
	
	static void register() {};
	
	private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
		
		return Registration.BLOCKS.register(name, block);
		
	}
	
	private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
		
		RegistryObject<T> ret = registerNoItem(name, block);
		Registration.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));
		return ret;
		
	}
	
	
	
}
