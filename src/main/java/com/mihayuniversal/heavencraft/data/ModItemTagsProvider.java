package com.mihayuniversal.heavencraft.data;

import com.mihayuniversal.heavencraft.init.ModItems;
import com.mihayuniversal.heavencraft.init.ModTags;
import com.mihayuniversal.heavencraft.util.Reference;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagsProvider extends ItemTagsProvider {

	public ModItemTagsProvider(DataGenerator gen, BlockTagsProvider provider, ExistingFileHelper exFileHelper) {
		super(gen, provider, Reference.MODID, exFileHelper);
	}
	
	@Override
	protected void addTags() {
		copy(ModTags.Blocks.ORES_ANGEL, ModTags.Items.ORES_ANGEL);
        copy(Tags.Blocks.ORES, Tags.Items.ORES);
        copy(ModTags.Blocks.STORAGE_BLOCKS_ANGEL, ModTags.Items.STORAGE_BLOCKS_ANGEL);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);

        tag(ModTags.Items.INGOTS_ANGEL).add(ModItems.ANGEL_INGOT.get());
        tag(Tags.Items.INGOTS).addTag(ModTags.Items.INGOTS_ANGEL);
	}
	
}
