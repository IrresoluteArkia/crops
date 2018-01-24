package com.irar.arcrops.potion;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class ArPotionEffects extends Potion{

	protected ArPotionEffects(boolean isBadEffectIn, int liquidColorIn) {
		super(isBadEffectIn, liquidColorIn);
		// TODO Auto-generated constructor stub
	}
	
	public static void registerPotions(){
		IForgeRegistry potionRegistry = GameRegistry.findRegistry(Potion.class);
//		potionRegistry.register(87, new ResourceLocation("arcrops:ghost"), (new ArPotionEffects(false, 8171462)).setPotionName("effect.ghost").setBeneficial());
	}

}
