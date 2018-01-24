package com.irar.arcrops.item;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.irar.arcrops.handlers.CreativeTabsHandler;

import net.minecraft.advancements.critereon.EffectsChangedTrigger;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.world.World;
import net.minecraftforge.client.event.GuiScreenEvent.PotionShiftEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FoodItem extends ItemFood{

	private static ArrayList<ArrayList<Object>> playersGhosting = new ArrayList<ArrayList<Object>>();
	private String name;
	private Random r = new Random();
	
	public FoodItem(String name, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		this.name = name;
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabsHandler.ARCROPS);
		if(name == "limarion"){
			this.setPotionEffect(new PotionEffect(Potion.getPotionById(19), 200, 1), 1.0F);
			this.setAlwaysEdible();
		}
		if(name == "instis"){
			this.setPotionEffect(new PotionEffect(Potion.getPotionById(10), 100, 2), 1.0F);
			this.setAlwaysEdible();
		}
		if(name == "random_berry"){
			this.setAlwaysEdible();
		}
		if(name == "ghost_berry"){
			this.setAlwaysEdible();
		}
	}

    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn){
    	if(!(this.name == "blend")){
	    	String special = "";
	    	if(this.name == "savilior"){
	    		special = "Feed";
	    	}else if(this.name == "limarion"){
	    		special = "Poison";
	    	}else if(this.name == "instis"){
	    		special = "Heal";
	    	}else if(this.name == "ghost_berry"){
	    		special = "Ghostify";
	    	}else{
	    		tooltip.add("§4§lWARNING: A CHUNK OF THE GAME§r");
	    		special = "§l§kRandom§r";
	    	}
	    	tooltip.add("Good Enough To "+ special +" A Whole Village!!!");
    	}else{
	    	tooltip.add("Looks So Good That You Want To Eat The Bowl As Well!!!");
    	}
    	super.addInformation(stack, worldIn, tooltip, flagIn);
    }
    
    @Override
    public void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player){
    	if(this.name == "random_berry"){
			this.setPotionEffect(new PotionEffect(Potion.getPotionById(r.nextInt(27) + 1), 20 * 60, r.nextInt(2)), 1.0F);
    	}
    	if(this.name == "ghost_berry"){
    		player.addPotionEffect(new PotionEffect(Potion.getPotionById(24), 20 * 60, 0));
    		player.addPotionEffect(new PotionEffect(Potion.getPotionById(14), 20 * 60, 0));
    		player.addPotionEffect(new PotionEffect(Potion.getPotionById(1), 20 * 60, 2));
    		player.addPotionEffect(new PotionEffect(Potion.getPotionById(4), 20 * 60, 99));
    		player.addPotionEffect(new PotionEffect(Potion.getPotionById(18), 20 * 60, 99));
    		player.addPotionEffect(new PotionEffect(Potion.getPotionById(11), 20 * 60, 99));
//    		player.addPotionEffect(new PotionEffect(Potion.getPotionById(87), 20 * 60, 0));
    		
    		boolean isAlreadyGhosting = false;
    		int index = 0;
    		
        	for(int i = 0; i < playersGhosting.size(); i++){
    			if(playersGhosting.get(i).get(0).equals(player.getUUID(player.getGameProfile()))){
    				isAlreadyGhosting = true;
    				index = i;
    			}
        	}
    		
    		ArrayList<Object> playerToGhost = new ArrayList<Object>();
    		playerToGhost.add(player.getUUID(player.getGameProfile()));
    		playerToGhost.add(60 * 20);
    		if(!isAlreadyGhosting){
        		playersGhosting.add(playerToGhost);
    		}else{
    			playersGhosting.remove(index);
        		playersGhosting.add(playerToGhost);
    		}
    	}
    	super.onFoodEaten(stack, worldIn, player);
    }
    
	static {
        final EventHandlerFly handler = new EventHandlerFly();
        MinecraftForge.EVENT_BUS.register((Object)handler);
        FMLCommonHandler.instance().bus().register((Object)handler);
    }
    
    public static class EventHandlerFly
    {
        @SubscribeEvent
        public void entTick(final LivingEvent.LivingUpdateEvent event) {
            if (event.getEntity().world.isRemote) {
                return;
            }
            if(event.getEntity() instanceof EntityPlayerMP){
            	final EntityPlayerMP entityPlayer = (EntityPlayerMP)event.getEntity();
            	
            	boolean isGhosting = false;
            	int index = 0;
            	
            	for(int i = 0; i < playersGhosting.size(); i++){
            		if(playersGhosting.get(i).get(0) instanceof UUID){
            			if(playersGhosting.get(i).get(0).equals(entityPlayer.getUUID(entityPlayer.getGameProfile()))){
            				isGhosting = true;
            				index = i;
            			}
            		}
            	}
            	
            	if(isGhosting){
            		if(!entityPlayer.isCreative()){
	            		entityPlayer.capabilities.allowFlying = true;
	            		entityPlayer.sendPlayerAbilities();
	            		int newNum = (int)playersGhosting.get(index).get(1) - 1;
	            		playersGhosting.get(index).remove(1);
	            		playersGhosting.get(index).add(newNum);
	            		
	            		if((int)playersGhosting.get(index).get(1) <= 0){
	            			playersGhosting.remove(index);
		            		entityPlayer.capabilities.allowFlying = false;
		            		entityPlayer.capabilities.isFlying = false;
		            		entityPlayer.sendPlayerAbilities();
	            		}
            		}
            	}
            }
        }
    }

}
