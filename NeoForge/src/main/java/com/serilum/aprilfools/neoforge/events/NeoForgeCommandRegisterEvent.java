package com.serilum.aprilfools.neoforge.events;

import com.serilum.aprilfools.cmds.CommandAprilFools;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

public class NeoForgeCommandRegisterEvent {
	@SubscribeEvent
	public static void registerCommands(RegisterCommandsEvent e) {
		CommandAprilFools.register(e.getDispatcher());
	}
}
