package com.natamus.aprilfools.forge.events;

import com.natamus.aprilfools.events.FoolsServerTickEvents;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;

import java.lang.invoke.MethodHandles;

public class ForgeFoolsServerTickEvents {
	public static void registerEventsInBus() {
		// BusGroup.DEFAULT.register(MethodHandles.lookup(), ForgeFoolsServerTickEvents.class);

		TickEvent.ServerTickEvent.Post.BUS.addListener(ForgeFoolsServerTickEvents::onServerTick);
	}

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent.Post e) {
        FoolsServerTickEvents.onServerTick(e.server());
    }
}
