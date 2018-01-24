package com.irar.arcrops.handlers;

import net.minecraftforge.oredict.OreDictionary;

public class OreDictHandler {
	
	public static void init(){
		OreDictionary.registerOre("fruitSavilior", ItemHandler.savilior);
		OreDictionary.registerOre("fruitLimarion", ItemHandler.limarion);
		OreDictionary.registerOre("fruitInstis", ItemHandler.instis);
		OreDictionary.registerOre("fiberWood", ItemHandler.woodFiber);
	}
	
}
