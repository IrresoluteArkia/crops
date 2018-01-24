package com.irar.arcrops.handlers;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CraftingHandler {

	public static void init() {
		GameRegistry.addShapedRecipe(new ResourceLocation("arcrops:recipe1"), new ResourceLocation("recipes"), new ItemStack(ItemHandler.woodFiber, 9), new Object[]{"WWW", "WWW", "WWW", 'W', Blocks.LOG});
		GameRegistry.addShapedRecipe(new ResourceLocation("arcrops:recipe2"), new ResourceLocation("recipes"), new ItemStack(Blocks.LOG, 8), new Object[]{"WWW", "W W", "WWW", 'W', ItemHandler.woodFiber});
		GameRegistry.addShapedRecipe(new ResourceLocation("arcrops:recipe3"), new ResourceLocation("recipes"), new ItemStack(Items.PAPER, 3), new Object[]{"W  ", " W ", "  W", 'W', ItemHandler.woodFiber});
		GameRegistry.addShapedRecipe(new ResourceLocation("arcrops:recipe4"), new ResourceLocation("recipes"), new ItemStack(Items.PAPER, 3), new Object[]{"  W", " W ", "W  ", 'W', ItemHandler.woodFiber});
		GameRegistry.addShapedRecipe(new ResourceLocation("arcrops:recipe5"), new ResourceLocation("recipes"), new ItemStack(ItemHandler.saviliorSeed, 2), new Object[]{"PDP", "DFD", "PDP", 'F', ItemHandler.woodFiber, 'P', Items.PAPER, 'D', new ItemStack(Items.DYE, 1, 1)});
		GameRegistry.addShapedRecipe(new ResourceLocation("arcrops:recipe6"), new ResourceLocation("recipes"), new ItemStack(ItemHandler.limarionSeed, 2), new Object[]{"PDP", "DFD", "PDP", 'F', ItemHandler.saviliorSeed, 'P', Items.PAPER, 'D', new ItemStack(Items.DYE, 1, 10)});
		GameRegistry.addShapedRecipe(new ResourceLocation("arcrops:recipe7"), new ResourceLocation("recipes"), new ItemStack(ItemHandler.instisSeed, 2), new Object[]{"PDP", "DFD", "PDP", 'F', ItemHandler.limarionSeed, 'P', Items.PAPER, 'D', Items.GLOWSTONE_DUST});
		GameRegistry.addShapedRecipe(new ResourceLocation("arcrops:recipe8"), new ResourceLocation("recipes"), new ItemStack(ItemHandler.blend), new Object[]{"SLI", "SLI", " B ", 'S', ItemHandler.savilior, 'L', ItemHandler.limarion, 'I', ItemHandler.instis, 'B', Items.BOWL});
		GameRegistry.addShapedRecipe(new ResourceLocation("arcrops:recipe9"), new ResourceLocation("recipes"), new ItemStack(ItemHandler.strangeMixture, 5), new Object[]{"LIL", "ILI", "LIL", 'L', ItemHandler.limarion, 'I', ItemHandler.instis});
		GameRegistry.addShapedRecipe(new ResourceLocation("arcrops:recipe10"), new ResourceLocation("recipes"), new ItemStack(ItemHandler.randomBerry, 9), new Object[]{"MMM", "MBM", "MMM", 'B', ItemHandler.limarion, 'M', ItemHandler.strangeMixture});
		GameRegistry.addShapedRecipe(new ResourceLocation("arcrops:recipe11"), new ResourceLocation("recipes"), new ItemStack(ItemHandler.randomBerry, 9), new Object[]{"MMM", "MBM", "MMM", 'B', ItemHandler.savilior, 'M', ItemHandler.strangeMixture});
		GameRegistry.addShapedRecipe(new ResourceLocation("arcrops:recipe12"), new ResourceLocation("recipes"), new ItemStack(ItemHandler.randomBerry, 9), new Object[]{"MMM", "MBM", "MMM", 'B', ItemHandler.instis, 'M', ItemHandler.strangeMixture});
		GameRegistry.addShapedRecipe(new ResourceLocation("arcrops:recipe13"), new ResourceLocation("recipes"), new ItemStack(ItemHandler.ghostBerry, 3), new Object[]{"MSM", "MLM", "MIM", 'I', ItemHandler.instis, 'L', ItemHandler.limarion, 'S', ItemHandler.savilior, 'M', ItemHandler.strangeMixture});
		GameRegistry.addShapelessRecipe(new ResourceLocation("arcrops:shapeless1"), new ResourceLocation("recipes"), new ItemStack(Items.DYE, 1, 10), Ingredient.fromItem(ItemHandler.savilior));
		GameRegistry.addShapelessRecipe(new ResourceLocation("arcrops:shapeless2"), new ResourceLocation("recipes"), new ItemStack(Items.GLOWSTONE_DUST), Ingredient.fromItem(ItemHandler.limarion));
		GameRegistry.addShapelessRecipe(new ResourceLocation("arcrops:shapeless3"), new ResourceLocation("recipes"), new ItemStack(Items.DYE, 1, 9), Ingredient.fromItem(ItemHandler.instis));
	}

}
