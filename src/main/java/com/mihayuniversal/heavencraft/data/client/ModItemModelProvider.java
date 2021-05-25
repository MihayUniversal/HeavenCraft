package com.mihayuniversal.heavencraft.data.client;

import com.mihayuniversal.heavencraft.util.Reference;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

	public ModItemModelProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
		super(gen, Reference.MODID, exFileHelper);
	}
	
	@Override
	protected void registerModels() {
		
		withExistingParent("angel_ore", modLoc("block/angel_ore"));
		withExistingParent("angel_block", modLoc("block/angel_block"));
		
		ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));
		
		builder(itemGenerated, "angel_ingot");
		
	}
	
	private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
		return getBuilder(name).parent(itemGenerated).texture("layer0", "item/"+name);
	}
	
	
}
