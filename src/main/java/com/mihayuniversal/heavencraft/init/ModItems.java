package com.mihayuniversal.heavencraft.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {
	
	public static final RegistryObject<Item> ANGEL_INGOT = Registration.ITEMS.register("angel_ingot", () ->
		
		new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS))
	
	);
	
	static void register() {}
	
}
