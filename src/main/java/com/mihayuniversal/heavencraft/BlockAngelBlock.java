package com.mihayuniversal.heavencraft;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraftforge.common.ToolType;

public class BlockAngelBlock extends Block {

	public BlockAngelBlock(Properties props) {
		super(props);
		props.harvestLevel(3);
		props.harvestTool(ToolType.PICKAXE);
		props.requiresCorrectToolForDrops();
		props.strength(12.0F);
		props.sound(SoundType.METAL);
	}
	
}
