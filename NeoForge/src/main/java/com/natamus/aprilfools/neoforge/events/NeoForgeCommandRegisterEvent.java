package com.natamus.aprilfools.neoforge.events;

import com.natamus.aprilfools.cmds.CommandAprilFools;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

public class NeoForgeCommandRegisterEvent {
	@SubscribeEvent
	public static void registerCommands(RegisterCommandsEvent e) {
		CommandAprilFools.register(e.getDispatcher());
	}
}
