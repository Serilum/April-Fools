package com.serilum.aprilfools.forge.events;

import com.serilum.aprilfools.events.FoolsSoundEvents;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgeFoolsSoundEvents {
	@SubscribeEvent
	public static void onSoundEvent(PlaySoundEvent e) {
		if (!FoolsSoundEvents.onSoundEvent(e.getEngine(), e.getOriginalSound())) {
			e.setSound(null);
		}
	}
}