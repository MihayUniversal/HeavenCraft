package com.mihayuniversal.heavencraft.data;

import com.google.common.collect.ImmutableList;
import com.mihayuniversal.heavencraft.init.ModBlocks;
import com.mihayuniversal.heavencraft.init.Registration;
import com.mojang.datafixers.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.loot.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ModLootTableProvider extends LootTableProvider {

	public ModLootTableProvider(DataGenerator gen) {
		super(gen);
	}
	
	@Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
        return ImmutableList.of(
        	Pair.of(ModBlockLootTables::new, LootParameterSets.BLOCK)
        );
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationtracker) {
        map.forEach((res, table) -> LootTableManager.validate(validationtracker, res, table));
    }
    
    public static class ModBlockLootTables extends BlockLootTables {
    	
    	 @Override
         protected void addTables() {
    		 dropSelf(ModBlocks.ANGEL_BLOCK.get());
    		 dropSelf(ModBlocks.ANGEL_ORE.get());
         }
    	 
    	 @Override
         protected Iterable<Block> getKnownBlocks() {
             return Registration.BLOCKS.getEntries().stream()
                     .map(RegistryObject::get)
                     .collect(Collectors.toList());
         }
    	
    }
	
}
