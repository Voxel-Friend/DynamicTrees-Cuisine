package com.github.voxelfriend.dyntreescuisine;


import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import com.github.voxelfriend.dyntreescuisine.DynTreesCuisine;

@Mod.EventBusSubscriber(modid = ModConstants.MODID)
public class ModModels {
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		DynTreesCuisine.proxy.registerModels();
	}
	
}