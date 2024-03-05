package com.natamus.aprilfools.forge.events;

import com.natamus.aprilfools.cmds.CommandAprilFools;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class ForgeCommandRegisterEvent {
    @SubscribeEvent
    public void registerCommands(RegisterCommandsEvent e) {
    	CommandAprilFools.register(e.getDispatcher());
    }
}
