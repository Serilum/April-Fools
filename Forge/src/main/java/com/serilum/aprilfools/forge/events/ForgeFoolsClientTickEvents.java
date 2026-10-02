package com.serilum.aprilfools.forge.events;

import com.serilum.aprilfools.events.FoolsClientTickEvents;
import net.minecraft.client.Minecraft;
import net.minecraftforge.event.TickEvent.ClientTickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgeFoolsClientTickEvents {
	@SubscribeEvent
	public static void onClientTick(ClientTickEvent e) {
		if (!e.phase.equals(Phase.END)) {
			return;
		}

		FoolsClientTickEvents.onClientTick(Minecraft.getInstance());
	}
}
