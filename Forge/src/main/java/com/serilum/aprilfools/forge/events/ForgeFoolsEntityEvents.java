package com.serilum.aprilfools.forge.events;

import com.serilum.aprilfools.events.FoolsEntityEvents;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgeFoolsEntityEvents {
	@SubscribeEvent
	public static void onSpawn(EntityJoinLevelEvent e) {
		FoolsEntityEvents.onSpawn(e.getLevel(), e.getEntity());
	}
}
