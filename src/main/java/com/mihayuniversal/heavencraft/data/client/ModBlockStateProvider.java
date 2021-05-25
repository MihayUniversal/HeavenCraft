package com.mihayuniversal.heavencraft.data.client;

import com.mihayuniversal.heavencraft.init.ModBlocks;
import com.mihayuniversal.heavencraft.util.Reference;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {

	public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
		super(gen, Reference.MODID, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		
		simpleBlock(ModBlocks.ANGEL_BLOCK.get());
		simpleBlock(ModBlocks.ANGEL_ORE.get());
		
		
	}

}
