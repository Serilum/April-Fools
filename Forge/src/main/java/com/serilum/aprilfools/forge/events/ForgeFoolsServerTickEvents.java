package com.serilum.aprilfools.forge.events;

import com.serilum.aprilfools.events.FoolsServerTickEvents;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgeFoolsServerTickEvents {
	@SubscribeEvent
	public static void onServerTick(TickEvent.ServerTickEvent e) {
		if (!e.phase.equals(TickEvent.Phase.END)) {
			return;
		}

		FoolsServerTickEvents.onServerTick(e.getServer());
	}
}
