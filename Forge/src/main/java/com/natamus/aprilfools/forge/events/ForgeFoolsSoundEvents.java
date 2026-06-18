package com.natamus.aprilfools.forge.events;

import com.natamus.aprilfools.events.FoolsSoundEvents;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;

import java.lang.invoke.MethodHandles;

public class ForgeFoolsSoundEvents {
	public static void registerEventsInBus() {
		// BusGroup.DEFAULT.register(MethodHandles.lookup(), ForgeFoolsSoundEvents.class);

		PlaySoundEvent.BUS.addListener(ForgeFoolsSoundEvents::onSoundEvent);
	}

	@SubscribeEvent
	public static void onSoundEvent(PlaySoundEvent e) {
		if (!FoolsSoundEvents.onSoundEvent(e.getEngine(), e.getOriginalSound())) {
			e.setSound(null);
		}
	}
}