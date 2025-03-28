package com.natamus.aprilfools.features;

import com.natamus.aprilfools.config.ConfigHandler;
import com.natamus.aprilfools.data.Sounds;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundEngine;
import net.minecraft.sounds.SoundEvent;

public class MakeCatsBarkDogsMeow {
	public static boolean init(SoundEngine soundEngine, SoundInstance soundInstance, String rawName) {
		if (!ConfigHandler.makeCatsBarkAndDogsMeow) {
			return false;
		}

		SoundEvent soundEvent;
		float volume;
		if (rawName.contains(".wolf")) {
			soundEvent = Sounds.FOOLS_CAT_SOUND_EVENT;
			volume = 0.55F;
		}
		else {
			soundEvent = Sounds.FOOLS_WOLF_SOUND_EVENT;
			volume = 1.0F;
		}

		SoundInstance newSoundInstance = SimpleSoundInstance.forLocalAmbience(soundEvent, volume, 1.0F);
		soundEngine.play(newSoundInstance);

		return true;
	}
}
