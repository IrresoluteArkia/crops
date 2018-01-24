package com.irar.arcrops.handlers;

import java.util.ArrayList;

import com.irar.arcrops.block.PlantBlock;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BlockHandler {
	
	public static Block woodPlant;
	public static Block saviliorPlant;
	public static Block limarionPlant;
	public static Block instisPlant;
	public static ArrayList<Block> allBlocks = new ArrayList<Block>();

	public static void init() {
		woodPlant = new PlantBlock("wood_crop", ItemHandler.woodFiber, ItemHandler.woodFiber, Blocks.LOG);
		saviliorPlant = new PlantBlock("savilior_crop", ItemHandler.saviliorSeed, ItemHandler.savilior, Blocks.LOG);
		limarionPlant = new PlantBlock("limarion_crop", ItemHandler.limarionSeed, ItemHandler.limarion, Blocks.LOG);
		instisPlant = new PlantBlock("instis_crop", ItemHandler.instisSeed, ItemHandler.instis, Blocks.LOG);
		
		
		allBlocks.add(woodPlant);
		allBlocks.add(saviliorPlant);
		allBlocks.add(limarionPlant);
		allBlocks.add(instisPlant);
	}

	public static void register() {
		for(int i = 0; i < allBlocks.size(); i++){
			ForgeRegistries.BLOCKS.register(allBlocks.get(i));
		}
	}

	public static void registerRenders() {
		for(int i = 0; i < allBlocks.size(); i++){
			registerRender(allBlocks.get(i));
		}
	}

	public static void registerRender(Block block){
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

}
