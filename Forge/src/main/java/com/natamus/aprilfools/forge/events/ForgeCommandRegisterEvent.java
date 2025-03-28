package com.natamus.aprilfools.forge.events;

import com.natamus.aprilfools.cmds.CommandAprilFools;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgeCommandRegisterEvent {
    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent e) {
    	CommandAprilFools.register(e.getDispatcher());
    }
}
