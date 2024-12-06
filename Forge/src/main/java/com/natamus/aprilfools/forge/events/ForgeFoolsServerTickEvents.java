package com.natamus.aprilfools.forge.events;

import com.natamus.aprilfools.events.FoolsServerTickEvents;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class ForgeFoolsServerTickEvents {
    @SubscribeEvent
    public void onServerTick(TickEvent.ServerTickEvent e) {
        if (!e.phase.equals(TickEvent.Phase.END)) {
            return;
        }

        FoolsServerTickEvents.onServerTick(e.getServer());
    }
}
