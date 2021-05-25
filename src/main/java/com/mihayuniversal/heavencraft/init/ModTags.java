package com.mihayuniversal.heavencraft.init;

import com.mihayuniversal.heavencraft.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class ModTags {
    public static final class Blocks {
        public static final ITag.INamedTag<Block> ORES_ANGEL = forge("ores/angel");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_ANGEL = forge("storage_blocks/angel");

        private static ITag.INamedTag<Block> forge(String path) {
            return BlockTags.bind(new ResourceLocation("forge", path).toString());
        }

        @SuppressWarnings("unused")
        private static ITag.INamedTag<Block> mod(String path) {
            return BlockTags.bind(new ResourceLocation(Reference.MODID, path).toString());
        }
    }
    
    public static final class Items {
        public static final ITag.INamedTag<Item> ORES_ANGEL = forge("ores/angel");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_ANGEL = forge("storage_blocks/angel");

        public static final ITag.INamedTag<Item> INGOTS_ANGEL = forge("ingots/angel");

        private static ITag.INamedTag<Item> forge(String path) {
            return ItemTags.bind(new ResourceLocation("forge", path).toString());
        }

        @SuppressWarnings("unused")
		private static ITag.INamedTag<Item> mod(String path) {
            return ItemTags.bind(new ResourceLocation(Reference.MODID, path).toString());
        }
    }
    
}