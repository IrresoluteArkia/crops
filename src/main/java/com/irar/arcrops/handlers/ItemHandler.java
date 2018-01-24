package com.irar.arcrops.handlers;

import java.util.ArrayList;

import com.irar.arcrops.item.FoodItem;
import com.irar.arcrops.item.NormalItem;
import com.irar.arcrops.item.PlantItem;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ItemHandler {
	
	public static Item woodFiber;
	public static Item saviliorSeed;
	public static Item savilior;
	public static Item limarionSeed;
	public static Item limarion;
	public static Item instisSeed;
	public static Item instis;
	public static Item randomBerry;
	public static Item ghostBerry;
	public static Item blend;
	public static Item strangeMixture;
	public static ArrayList<Item> allItems = new ArrayList<Item>();

	public static void init() {
		woodFiber = new PlantItem("wood_fiber");
		saviliorSeed = new PlantItem("savilior_seed");
		savilior = new FoodItem("savilior", 4, 1.0F, false);
		limarionSeed = new PlantItem("limarion_seed");
		limarion = new FoodItem("limarion", 6, 0.1F, false);
		instisSeed = new PlantItem("instis_seed");
		instis = new FoodItem("instis", 1, 0.0F, false);
		randomBerry = new FoodItem("random_berry", 0, 0.0F, false);
		ghostBerry = new FoodItem("ghost_berry", 1, 0.2F, false);
		blend = new FoodItem("blend", 20, 1.0F, true);
		strangeMixture = new NormalItem("strange_mixture");
		
		allItems.add(woodFiber);
		allItems.add(saviliorSeed);
		allItems.add(savilior);
		allItems.add(limarionSeed);
		allItems.add(limarion);
		allItems.add(instisSeed);
		allItems.add(instis);
		allItems.add(randomBerry);
		allItems.add(ghostBerry);
		allItems.add(blend);
		allItems.add(strangeMixture);
	}

	public static void addItemBlock(Block block){
		ItemBlock itemBlock = new ItemBlock(block);
		itemBlock.setRegistryName(block.getRegistryName());
		ForgeRegistries.ITEMS.register(itemBlock);
		registerRender(itemBlock);
		allItems.add(itemBlock);
	}
	
	public static void register() {
		for(int i = 0; i < allItems.size(); i++){
			ForgeRegistries.ITEMS.register(allItems.get(i));
		}
	}

	public static void registerRenders() {
		for(int i = 0; i < allItems.size(); i++){
			registerRender(allItems.get(i));
		}
	}

	public static void registerRender(Item item){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

}
