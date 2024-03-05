package com.natamus.aprilfools.neoforge.events;

import com.natamus.aprilfools.events.FoolsClientTickEvents;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod.EventBusSubscriber;
import net.neoforged.neoforge.event.TickEvent.ClientTickEvent;
import net.neoforged.neoforge.event.TickEvent.Phase;

@EventBusSubscriber(value = Dist.CLIENT)
public class NeoForgeFoolsClientTickEvents {
	@SubscribeEvent
	public static void onClientTick(ClientTickEvent e) {
		if (!e.phase.equals(Phase.END)) {
			return;
		}

		FoolsClientTickEvents.onClientTick(Minecraft.getInstance());
	}
}
