package com.natamus.aprilfools.neoforge.events;

import com.natamus.aprilfools.events.FoolsServerTickEvents;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.ServerTickEvent;

@EventBusSubscriber
public class NeoForgeFoolsServerTickEvents {
	@SubscribeEvent
	public static void onServerTick(ServerTickEvent.Post e) {
		FoolsServerTickEvents.onServerTick(e.getServer());
	}
}
