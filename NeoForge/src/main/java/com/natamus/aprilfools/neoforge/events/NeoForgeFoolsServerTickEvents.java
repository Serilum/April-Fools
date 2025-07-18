package com.natamus.aprilfools.neoforge.events;

import com.natamus.aprilfools.events.FoolsServerTickEvents;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;

public class NeoForgeFoolsServerTickEvents {
	@SubscribeEvent
	public static void onServerTick(ServerTickEvent.Post e) {
		FoolsServerTickEvents.onServerTick(e.getServer());
	}
}
