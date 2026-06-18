package com.natamus.aprilfools.neoforge.events;

import com.natamus.aprilfools.events.FoolsClientTickEvents;
import net.minecraft.client.Minecraft;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;

public class NeoForgeFoolsClientTickEvents {
	@SubscribeEvent
	public static void onClientTick(ClientTickEvent.Post e) {
		FoolsClientTickEvents.onClientTick(Minecraft.getInstance());
	}
}
