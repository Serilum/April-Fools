package com.serilum.aprilfools;

import com.serilum.aprilfools.data.Sounds;
import com.serilum.aprilfools.forge.config.IntegrateForgeConfig;
import com.serilum.aprilfools.forge.events.*;
import com.serilum.aprilfools.util.Reference;
import com.natamus.collective.check.RegisterMod;
import com.natamus.collective.check.ShouldLoadCheck;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(Reference.MOD_ID)
public class ModForge {

	public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Reference.MOD_ID);

	public static final RegistryObject<SoundEvent> FOOLS_CAT_AMBIENT_OBJECT = SOUND_EVENTS.register(Sounds.FOOLS_CAT_AMBIENT_LOCATION.getPath(), () -> Sounds.FOOLS_CAT_SOUND_EVENT);
	public static final RegistryObject<SoundEvent> FOOLS_WOLF_AMBIENT_OBJECT = SOUND_EVENTS.register(Sounds.FOOLS_WOLF_AMBIENT_LOCATION.getPath(), () -> Sounds.FOOLS_WOLF_SOUND_EVENT);


	public ModForge(FMLJavaModLoadingContext modLoadingContext) {
		if (!ShouldLoadCheck.shouldLoad(Reference.MOD_ID)) {
			return;
		}

		BusGroup busGroup = modLoadingContext.getModBusGroup();
		FMLLoadCompleteEvent.getBus(busGroup).addListener(this::loadComplete);

		SOUND_EVENTS.register(busGroup);

		setGlobalConstants();
		ModCommon.init();

		IntegrateForgeConfig.registerScreen(modLoadingContext);

		RegisterMod.register(Reference.NAME, Reference.MOD_ID, Reference.VERSION, Reference.ACCEPTED_VERSIONS);
	}

	private void loadComplete(final FMLLoadCompleteEvent event) {
		ForgeCommandRegisterEvent.registerEventsInBus();

		ForgeFoolsServerTickEvents.registerEventsInBus();
		ForgeFoolsBlockEvents.registerEventsInBus();
		ForgeFoolsEntityEvents.registerEventsInBus();

		if (FMLEnvironment.dist.equals(Dist.CLIENT)) {
			ForgeFoolsClientTickEvents.registerEventsInBus();
			ForgeFoolsSoundEvents.registerEventsInBus();
		}
	}

	private static void setGlobalConstants() {

	}
}