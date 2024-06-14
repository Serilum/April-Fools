package com.natamus.aprilfools.forge.events;

import com.natamus.aprilfools.events.FoolsBlockEvents;
import com.natamus.collective.functions.WorldFunctions;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class ForgeFoolsBlockEvents {
	@SubscribeEvent
	public void onBlockBreak(BlockEvent.BreakEvent e) {
		Level level = WorldFunctions.getWorldIfInstanceOfAndNotRemote(e.getLevel());
		if (level == null) {
			return;
		}

		FoolsBlockEvents.onBlockBreak(level, e.getPlayer(), e.getPos(), e.getState(), null);
	}
}
