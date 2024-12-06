package com.natamus.aprilfools;

import com.natamus.aprilfools.data.Sounds;
import com.natamus.aprilfools.forge.config.IntegrateForgeConfig;
import com.natamus.aprilfools.forge.events.*;
import com.natamus.aprilfools.util.Reference;
import com.natamus.collective.check.RegisterMod;
import com.natamus.collective.check.ShouldLoadCheck;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
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

		IEventBus modEventBus = modLoadingContext.getModEventBus();
		modEventBus.addListener(this::loadComplete);

		SOUND_EVENTS.register(modEventBus);

		setGlobalConstants();
		ModCommon.init();

		IntegrateForgeConfig.registerScreen(modLoadingContext);

		RegisterMod.register(Reference.NAME, Reference.MOD_ID, Reference.VERSION, Reference.ACCEPTED_VERSIONS);
	}

	private void loadComplete(final FMLLoadCompleteEvent event) {
		MinecraftForge.EVENT_BUS.register(new ForgeCommandRegisterEvent());

		MinecraftForge.EVENT_BUS.register(new ForgeFoolsServerTickEvents());
		MinecraftForge.EVENT_BUS.register(new ForgeFoolsBlockEvents());
		MinecraftForge.EVENT_BUS.register(new ForgeFoolsEntityEvents());

		if (FMLEnvironment.dist.equals(Dist.CLIENT)) {
			MinecraftForge.EVENT_BUS.register(new ForgeFoolsClientTickEvents());
			MinecraftForge.EVENT_BUS.register(new ForgeFoolsSoundEvents());
		}
	}

	private static void setGlobalConstants() {

	}
}