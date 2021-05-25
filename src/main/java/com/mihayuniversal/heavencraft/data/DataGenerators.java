package com.mihayuniversal.heavencraft.data;

import com.mihayuniversal.heavencraft.data.client.ModBlockStateProvider;
import com.mihayuniversal.heavencraft.data.client.ModItemModelProvider;
import com.mihayuniversal.heavencraft.util.Reference;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
	
	private DataGenerators() {}
	
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
			
		DataGenerator gen = event.getGenerator();
		ExistingFileHelper exFileHelper = event.getExistingFileHelper();
		
		gen.addProvider(new ModBlockStateProvider(gen, exFileHelper));
		gen.addProvider(new ModItemModelProvider(gen, exFileHelper));
		
		ModBlockTagsProvider blockTags = new ModBlockTagsProvider(gen, exFileHelper);
		gen.addProvider(blockTags);
		gen.addProvider(new ModItemTagsProvider(gen, blockTags, exFileHelper));
		
		gen.addProvider(new ModLootTableProvider(gen));
		gen.addProvider(new ModRecipeProvider(gen));
	}
	
}
