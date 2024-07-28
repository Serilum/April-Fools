package com.natamus.aprilfools;

import com.natamus.aprilfools.data.Sounds;
import com.natamus.aprilfools.neoforge.config.IntegrateNeoForgeConfig;
import com.natamus.aprilfools.neoforge.events.*;
import com.natamus.aprilfools.util.Reference;
import com.natamus.collective.check.RegisterMod;
import com.natamus.collective.check.ShouldLoadCheck;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(Reference.MOD_ID)
public class ModNeoForge {
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(Registries.SOUND_EVENT, Reference.MOD_ID);

	public static final DeferredHolder<SoundEvent, SoundEvent> FOOLS_CAT_AMBIENT_OBJECT = SOUND_EVENTS.register(Sounds.FOOLS_CAT_AMBIENT_LOCATION.getPath(), () -> Sounds.FOOLS_CAT_SOUND_EVENT);
	public static final DeferredHolder<SoundEvent, SoundEvent> FOOLS_WOLF_AMBIENT_OBJECT = SOUND_EVENTS.register(Sounds.FOOLS_WOLF_AMBIENT_LOCATION.getPath(), () -> Sounds.FOOLS_WOLF_SOUND_EVENT);
	
	public ModNeoForge(IEventBus modEventBus) {
		if (!ShouldLoadCheck.shouldLoad(Reference.MOD_ID)) {
			return;
		}

		modEventBus.addListener(this::loadComplete);

		SOUND_EVENTS.register(modEventBus);

		setGlobalConstants();
		ModCommon.init();

		IntegrateNeoForgeConfig.registerScreen(ModLoadingContext.get());

		RegisterMod.register(Reference.NAME, Reference.MOD_ID, Reference.VERSION, Reference.ACCEPTED_VERSIONS);
	}

	private void loadComplete(final FMLLoadCompleteEvent event) {
		NeoForge.EVENT_BUS.register(NeoForgeCommandRegisterEvent.class);

		NeoForge.EVENT_BUS.register(NeoForgeFoolsServerTickEvents.class);
		NeoForge.EVENT_BUS.register(NeoForgeFoolsBlockEvents.class);
		NeoForge.EVENT_BUS.register(NeoForgeFoolsEntityEvents.class);

		if (FMLEnvironment.dist.equals(Dist.CLIENT)) {
			NeoForge.EVENT_BUS.register(NeoForgeFoolsClientTickEvents.class);
			NeoForge.EVENT_BUS.register(NeoForgeFoolsSoundEvents.class);
		}
	}

	private static void setGlobalConstants() {

	}
}