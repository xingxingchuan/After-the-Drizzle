package roito.cultivage.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import roito.cultivage.Cultivage;
import roito.cultivage.common.tileentity.TileEntityFlatBasket;
import roito.cultivage.registry.GuiElementsRegistry;

import javax.annotation.Nullable;
import java.util.List;

public class BlockFlatBasket extends Block
{
	protected static final AxisAlignedBB AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.3125D, 1.0D);
	protected static final AxisAlignedBB AABB_BOTTOM = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.0625D, 1.0D);
	protected static final AxisAlignedBB AABB_SIDE1 = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.3125D, 0.0625D);
	protected static final AxisAlignedBB AABB_SIDE2 = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.0625D, 0.3125D, 1.0D);
	protected static final AxisAlignedBB AABB_SIDE3 = new AxisAlignedBB(0.9375D, 0.0D, 0.0D, 1.0D, 0.3125D, 1.0D);
	protected static final AxisAlignedBB AABB_SIDE4 = new AxisAlignedBB(0.0D, 0.0D, 0.9375D, 1.0D, 0.3125D, 1.0D);

	public BlockFlatBasket()
	{
		super(Material.WOOD);
		this.setHardness(0.5F);
		this.setSoundType(SoundType.WOOD);
		this.setTranslationKey("flat_basket");
		this.setCreativeTab(Cultivage.TAB_CRAFT);
	}

	@Override
	@SuppressWarnings("deprecation")
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState)
	{
		addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_BOTTOM);
		addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_SIDE1);
		addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_SIDE2);
		addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_SIDE3);
		addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_SIDE4);
	}

	@Override
	@SuppressWarnings("deprecation")
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return AABB;
	}

	@Override
	@SuppressWarnings("deprecation")
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
	{
		return BlockFaceShape.UNDEFINED;
	}

	@Override
	@SuppressWarnings("deprecation")
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}

	@Override
	@SuppressWarnings("deprecation")
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}

	@Override
	public boolean hasTileEntity(IBlockState state)
	{
		return true;
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState state)
	{
		return new TileEntityFlatBasket();
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		TileEntity te = worldIn.getTileEntity(pos);
		if (te != null && te instanceof TileEntityFlatBasket)
		{
			((TileEntityFlatBasket) te).refreshSeed();
			if (!playerIn.isSneaking() && !worldIn.isRemote)
			{
				if (((TileEntityFlatBasket) te).isEmpty())
				{
					if (!playerIn.getHeldItem(hand).isEmpty())
					{
						((TileEntityFlatBasket) te).putItemStackIn(playerIn.getHeldItem(hand));
						playerIn.setHeldItem(hand, ItemStack.EMPTY);
						return true;
					}
				}
				else if (((TileEntityFlatBasket) te).isCompleted())
				{
					worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, ((TileEntityFlatBasket) te).getInput()));
					((TileEntityFlatBasket) te).putItemStackIn(ItemStack.EMPTY);
					return true;
				}
			}
		}
		if (!worldIn.isRemote && playerIn.isSneaking())
		{
			int id = GuiElementsRegistry.GUI_FLAT_BAKSET;
			playerIn.openGui(Cultivage.getInstance(), id, worldIn, pos.getX(), pos.getY(), pos.getZ());
			return true;
		}
		return true;
	}
}
