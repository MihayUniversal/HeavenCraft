package com.mihayuniversal.heavencraft.init;

import java.util.function.Supplier;

import com.mihayuniversal.heavencraft.block.angelfurnace.AngelFurnaceTileEntity;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;

public class ModTileEntityTypes {
	
	public static final RegistryObject<TileEntityType<AngelFurnaceTileEntity>> ANGEL_FURNACE = register( "angel_furnace", AngelFurnaceTileEntity::new, ModBlocks.ANGEL_FURNACE );

    static void register() {}

    private static <T extends TileEntity> RegistryObject<TileEntityType<T>> register(String name, Supplier<T> factory, RegistryObject<? extends Block> block) {
        return Registration.TILE_ENTITIES.register(name, () -> {
            //noinspection ConstantConditions
            return TileEntityType.Builder.of(factory, block.get()).build(null);
        });
    }
	
}
