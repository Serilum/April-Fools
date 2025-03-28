package com.natamus.aprilfools.forge.events;

import com.natamus.aprilfools.events.FoolsServerTickEvents;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgeFoolsServerTickEvents {
    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent e) {
        if (!e.phase.equals(TickEvent.Phase.END)) {
            return;
        }

        FoolsServerTickEvents.onServerTick(e.getServer());
    }
}
