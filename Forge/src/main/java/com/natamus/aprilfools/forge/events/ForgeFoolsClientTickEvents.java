package com.natamus.aprilfools.forge.events;

import com.natamus.aprilfools.events.FoolsClientTickEvents;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
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
