package com.natamus.aprilfools;

import com.natamus.aprilfools.events.FoolsClientTickEvents;
import com.natamus.aprilfools.events.FoolsSoundEvents;
import com.natamus.collective.fabric.callbacks.CollectiveSoundEvents;
import net.fabricmc.api.ClientModInitializer;
import com.natamus.aprilfools.util.Reference;
import com.natamus.collective.check.ShouldLoadCheck;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundEngine;

public class ModFabricClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		if (!ShouldLoadCheck.shouldLoad(Reference.MOD_ID)) {
			return;
		}

		ClientTickEvents.END_CLIENT_TICK.register((Minecraft mc) -> {
			FoolsClientTickEvents.onClientTick(mc);
		});

		CollectiveSoundEvents.SOUND_PLAY.register((SoundEngine soundEngine, SoundInstance soundInstance) -> {
			return FoolsSoundEvents.onSoundEvent(soundEngine, soundInstance);
		});
	}
}
