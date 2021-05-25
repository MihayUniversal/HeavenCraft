package com.mihayuniversal.heavencraft.data;

import com.mihayuniversal.heavencraft.init.ModBlocks;
import com.mihayuniversal.heavencraft.init.ModTags;
import com.mihayuniversal.heavencraft.util.Reference;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider {

	public ModBlockTagsProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
		super(gen, Reference.MODID, exFileHelper);
	}
	
	@Override
	protected void addTags() {
		tag(ModTags.Blocks.ORES_ANGEL).add(ModBlocks.ANGEL_ORE.get());
        tag(Tags.Blocks.ORES).addTag(ModTags.Blocks.ORES_ANGEL);
        tag(ModTags.Blocks.STORAGE_BLOCKS_ANGEL).add(ModBlocks.ANGEL_BLOCK.get());
        tag(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.STORAGE_BLOCKS_ANGEL);
	}
}
