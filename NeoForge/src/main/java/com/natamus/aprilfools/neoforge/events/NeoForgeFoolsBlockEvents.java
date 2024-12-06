package com.natamus.aprilfools.neoforge.events;

import com.natamus.aprilfools.events.FoolsBlockEvents;
import com.natamus.collective.functions.WorldFunctions;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;

@EventBusSubscriber
public class NeoForgeFoolsBlockEvents {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent e) {
		Level level = WorldFunctions.getWorldIfInstanceOfAndNotRemote(e.getLevel());
		if (level == null) {
			return;
		}

		FoolsBlockEvents.onBlockBreak(level, e.getPlayer(), e.getPos(), e.getState(), null);
	}
}
