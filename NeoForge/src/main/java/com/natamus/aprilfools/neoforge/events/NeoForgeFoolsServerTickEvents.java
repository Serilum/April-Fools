package com.natamus.aprilfools.neoforge.events;

import com.natamus.aprilfools.events.FoolsServerTickEvents;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod.EventBusSubscriber;
import net.neoforged.neoforge.event.TickEvent;

@EventBusSubscriber
public class NeoForgeFoolsServerTickEvents {
	@SubscribeEvent
	public static void onServerTick(TickEvent.ServerTickEvent e) {
		if (!e.phase.equals(TickEvent.Phase.END)) {
			return;
		}

		FoolsServerTickEvents.onServerTick(e.getServer());
	}
}
