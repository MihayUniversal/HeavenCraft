package com.mihayuniversal.heavencraft.block.angelfurnace;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class AngelFurnaceBlock extends Block {

	public static final DirectionProperty FACING = HorizontalBlock.FACING;
	
	public AngelFurnaceBlock(Properties props) {
		super(props);
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
	
	@Nullable
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new AngelFurnaceTileEntity();
	}
	
	@Override
	public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult ray) {
		if(world.isClientSide) {
			return ActionResultType.SUCCESS;
		}
		this.interactWith(world, pos, player);
		return ActionResultType.CONSUME;
	}
	
	private void interactWith(World world, BlockPos pos, PlayerEntity player) {
		TileEntity ent = world.getBlockEntity(pos);
		if(ent instanceof AngelFurnaceTileEntity && player instanceof ServerPlayerEntity) {
			AngelFurnaceTileEntity aent = (AngelFurnaceTileEntity) ent;
			NetworkHooks.openGui((ServerPlayerEntity) player, aent, aent::encodeExtraData);
		}
	}
	
	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void onRemove(BlockState state, World world, BlockPos pos, BlockState newState, boolean isMoving) {
		if(!state.is(newState.getBlock())) {
			TileEntity ent = world.getBlockEntity(pos);
			if(ent instanceof IInventory) {
				InventoryHelper.dropContents(world, pos, (IInventory) ent);
				world.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, world, pos, newState, isMoving);
		}
	}
	
	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public BlockState mirror(BlockState state, Mirror mirror) {
		return state.rotate(mirror.getRotation(state.getValue(FACING)));
	}
	
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}
	
	
}
