package com.irar.arcrops.item;

import java.util.List;

import com.irar.arcrops.handlers.CreativeTabsHandler;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class NormalItem extends Item{
	private String name;
	
	public NormalItem(String name) {
		super();
		this.name = name;
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabsHandler.ARCROPS);
	}
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn){
    	if(name == "strange_mixture"){
    		tooltip.add("Are You Sure This Was A Good Idea?");
    	}
    	super.addInformation(stack, worldIn, tooltip, flagIn);
    }

}
