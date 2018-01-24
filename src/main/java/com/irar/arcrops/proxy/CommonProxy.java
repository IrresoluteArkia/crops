package com.irar.arcrops.proxy;



import com.irar.arcrops.handlers.BlockHandler;
import com.irar.arcrops.handlers.CraftingHandler;
import com.irar.arcrops.handlers.ItemHandler;
import com.irar.arcrops.handlers.OreDictHandler;
import com.irar.arcrops.potion.ArPotionEffects;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy implements IProxy{

	@Override
	public void preInit() {
//		ArPotionEffects.registerPotions();
		ItemHandler.init();
		ItemHandler.register();

		BlockHandler.init();
		BlockHandler.register();
		
//		GameRegistry.registerWorldGenerator(new WorldGenOre(), 0);
		
		OreDictHandler.init();
		
	}

	@Override
	public void init() {
		
	}

	@Override
	public void postInit() {
		CraftingHandler.init();
	}

}
