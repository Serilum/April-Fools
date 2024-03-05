package com.natamus.aprilfools.events;

import com.natamus.aprilfools.features.MakeCatsBarkDogsMeow;
import com.natamus.aprilfools.util.Util;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundEngine;

public class FoolsSoundEvents {
	public static boolean onSoundEvent(SoundEngine soundEngine, SoundInstance soundInstance) {
		if (!Util.areAprilFoolsFeaturesEnabled()) {
			return true;
		}

		String rawName = soundInstance.getLocation().toString();
		if (rawName.contains("ambient") && (rawName.contains(".wolf") || rawName.contains(".cat"))) {
			if (MakeCatsBarkDogsMeow.init(soundEngine, soundInstance, rawName)) {
				return false;
			}
		}

		return true;
	}
}
