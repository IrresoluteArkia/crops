package com.irar.arcrops.proxy;

import com.irar.arcrops.handlers.BlockHandler;
import com.irar.arcrops.handlers.ItemHandler;

public class ClientProxy extends CommonProxy{
	public void init(){
		ItemHandler.registerRenders();
		BlockHandler.registerRenders();
//		OreDictHandler.init();
	}
}
