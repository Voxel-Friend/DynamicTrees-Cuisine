package com.github.voxelfriend.dyntreescuisine;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import com.github.voxelfriend.dyntreescuisine.ModBlocks;

@Mod.EventBusSubscriber(modid = ModConstants.MODID)
public class ModRecipes {

	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void registerRecipes(final RegistryEvent.Register<IRecipe> event) {
		
	}
	
}
