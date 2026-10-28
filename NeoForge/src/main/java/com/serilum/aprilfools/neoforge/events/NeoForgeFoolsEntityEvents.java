package com.serilum.aprilfools.neoforge.events;

import com.serilum.aprilfools.events.FoolsEntityEvents;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;

public class NeoForgeFoolsEntityEvents {
	@SubscribeEvent
	public static void onSpawn(EntityJoinLevelEvent e) {
		FoolsEntityEvents.onSpawn(e.getLevel(), e.getEntity());
	}
}
