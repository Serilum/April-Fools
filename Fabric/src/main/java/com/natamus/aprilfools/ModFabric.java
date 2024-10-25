package com.natamus.aprilfools;

import com.natamus.aprilfools.cmds.CommandAprilFools;
import com.natamus.aprilfools.data.Sounds;
import com.natamus.aprilfools.events.FoolsBlockEvents;
import com.natamus.aprilfools.events.FoolsEntityEvents;
import com.natamus.aprilfools.events.FoolsServerTickEvents;
import com.natamus.aprilfools.util.Reference;
import com.natamus.collective.check.RegisterMod;
import com.natamus.collective.check.ShouldLoadCheck;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;

public class ModFabric implements ModInitializer {
	
	@Override
	public void onInitialize() {
		if (!ShouldLoadCheck.shouldLoad(Reference.MOD_ID)) {
			return;
		}

		setGlobalConstants();
		ModCommon.init();

		registerSounds();
		loadEvents();

		RegisterMod.register(Reference.NAME, Reference.MOD_ID, Reference.VERSION, Reference.ACCEPTED_VERSIONS);
	}

	private void registerSounds() {
		Registry.register(BuiltInRegistries.SOUND_EVENT, Sounds.FOOLS_CAT_AMBIENT_LOCATION, Sounds.FOOLS_CAT_SOUND_EVENT);
	}

	private void loadEvents() {
		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			CommandAprilFools.register(dispatcher);
		});

		ServerTickEvents.END_SERVER_TICK.register((MinecraftServer minecraftServer) -> {
			FoolsServerTickEvents.onServerTick(minecraftServer);
		});

		PlayerBlockBreakEvents.BEFORE.register((level, player, blockPos, blockState, blockEntity) -> {
			return FoolsBlockEvents.onBlockBreak(level, player, blockPos, blockState, blockEntity);
		});

		ServerEntityEvents.ENTITY_LOAD.register((Entity entity, ServerLevel level) -> {
			FoolsEntityEvents.onSpawn(level, entity);
		});
	}

	private static void setGlobalConstants() {

	}
}
