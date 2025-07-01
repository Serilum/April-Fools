package com.natamus.aprilfools.forge.events;

import com.natamus.aprilfools.events.FoolsEntityEvents;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;

import java.lang.invoke.MethodHandles;

public class ForgeFoolsEntityEvents {
	public static void registerEventsInBus() {
		// BusGroup.DEFAULT.register(MethodHandles.lookup(), ForgeFoolsEntityEvents.class);

		EntityJoinLevelEvent.BUS.addListener(ForgeFoolsEntityEvents::onSpawn);
	}

	@SubscribeEvent
	public static void onSpawn(EntityJoinLevelEvent e) {
		FoolsEntityEvents.onSpawn(e.getLevel(), e.getEntity());
	}
}
