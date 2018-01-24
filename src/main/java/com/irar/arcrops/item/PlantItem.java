package com.irar.arcrops.item;

import java.util.List;

import com.irar.arcrops.handlers.BlockHandler;
import com.irar.arcrops.handlers.CreativeTabsHandler;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class PlantItem extends Item implements IPlantable{
	
	private Block crops;
	private String name;
	
	public PlantItem(String name){
		super();
		this.name = name;
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabsHandler.ARCROPS);
	}
	
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
//    	if(this.name == "wood_fiber" || this.name == "savilior_seed"){
	        ItemStack itemstack = player.getHeldItem(hand);
	        IBlockState state = worldIn.getBlockState(pos);
	        if (facing == EnumFacing.UP && player.canPlayerEdit(pos.offset(facing), facing, itemstack) && worldIn.isAirBlock(pos.up()) && BlockHandler.woodPlant.canPlaceBlockAt(worldIn, pos.up()))
	        {
	        	if(this.name == "wood_fiber"){
	        		worldIn.setBlockState(pos.up(), BlockHandler.woodPlant.getDefaultState());
	        	}else if(this.name == "savilior_seed"){
	        		worldIn.setBlockState(pos.up(), BlockHandler.saviliorPlant.getDefaultState());
	        	}else if(this.name == "limarion_seed"){
	        		worldIn.setBlockState(pos.up(), BlockHandler.limarionPlant.getDefaultState());
	        	}else if(this.name == "instis_seed"){
	        		worldIn.setBlockState(pos.up(), BlockHandler.instisPlant.getDefaultState());
	        	}
	
	            if (player instanceof EntityPlayerMP)
	            {
	                CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)player, pos.up(), itemstack);
	            }
	
	            itemstack.shrink(1);
	            return EnumActionResult.SUCCESS;
	        }
	        else
	        {
	            return EnumActionResult.FAIL;
	        }
//    	}
//        return EnumActionResult.FAIL;
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos)
    {
        return EnumPlantType.Crop;
    }

    @Override
    public IBlockState getPlant(IBlockAccess world, BlockPos pos)
    {
        return BlockHandler.woodPlant.getDefaultState();
    }
    
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn){
    	tooltip.add("Plant Me On Wood!");
    	super.addInformation(stack, worldIn, tooltip, flagIn);
    }

}
