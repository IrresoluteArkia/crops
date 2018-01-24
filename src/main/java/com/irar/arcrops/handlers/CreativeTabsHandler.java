package com.irar.arcrops.handlers;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabsHandler {

	public static CreativeTabs ARCROPS = new CreativeTabs("arcrops"){

		public ItemStack getTabIconItem() {
			return new ItemStack(ItemHandler.woodFiber);
		}
		
	};

}
