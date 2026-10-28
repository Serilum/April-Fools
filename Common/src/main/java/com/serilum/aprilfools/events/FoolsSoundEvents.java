package com.serilum.aprilfools.events;

import com.serilum.aprilfools.features.MakeCatsBarkDogsMeow;
import com.serilum.aprilfools.util.Util;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundEngine;

public class FoolsSoundEvents {
	public static boolean onSoundEvent(SoundEngine soundEngine, SoundInstance soundInstance) {
		if (!Util.areAprilFoolsFeaturesEnabled()) {
			return true;
		}

		String rawName = soundInstance.getIdentifier().toString();
		if (rawName.contains("ambient") && (rawName.contains(".wolf") || rawName.contains(".cat"))) {
			return !MakeCatsBarkDogsMeow.init(soundEngine, soundInstance, rawName);
		}

		return true;
	}
}
