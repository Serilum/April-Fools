package com.natamus.aprilfools.neoforge.events;

import com.natamus.aprilfools.events.FoolsSoundEvents;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.sound.PlaySoundEvent;

public class NeoForgeFoolsSoundEvents {
	@SubscribeEvent
	public static void onSoundEvent(PlaySoundEvent e) {
		if (!FoolsSoundEvents.onSoundEvent(e.getEngine(), e.getOriginalSound())) {
			e.setSound(null);
		}
	}
}