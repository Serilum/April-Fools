package com.natamus.aprilfools.forge.events;

import com.natamus.aprilfools.events.FoolsClientTickEvents;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent.ClientTickEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;

import java.lang.invoke.MethodHandles;

public class ForgeFoolsClientTickEvents {
	public static void registerEventsInBus() {
		// BusGroup.DEFAULT.register(MethodHandles.lookup(), ForgeFoolsClientTickEvents.class);

		ClientTickEvent.Pre.BUS.addListener(ForgeFoolsClientTickEvents::onClientTick);
	}

	@SubscribeEvent
	public static void onClientTick(ClientTickEvent.Pre e) {
		FoolsClientTickEvents.onClientTick(Minecraft.getInstance());
	}
}
