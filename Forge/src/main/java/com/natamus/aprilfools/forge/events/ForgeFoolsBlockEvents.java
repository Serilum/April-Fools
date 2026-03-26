package com.natamus.aprilfools.forge.events;

import com.natamus.aprilfools.events.FoolsBlockEvents;
import com.natamus.collective.functions.WorldFunctions;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;

import java.lang.invoke.MethodHandles;

public class ForgeFoolsBlockEvents {
	public static void registerEventsInBus() {
		// BusGroup.DEFAULT.register(MethodHandles.lookup(), ForgeFoolsBlockEvents.class);

		BlockEvent.BreakEvent.BUS.addListener(ForgeFoolsBlockEvents::onBlockBreak);
	}

	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent e) {
		Level level = WorldFunctions.getWorldIfInstanceOfAndNotRemote(e.getLevel());
		if (level == null) {
			return;
		}

		FoolsBlockEvents.onBlockBreak(level, e.getPlayer(), e.getPos(), e.getState(), null);
	}
}
