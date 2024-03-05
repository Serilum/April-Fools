package com.natamus.aprilfools.neoforge.events;

import com.natamus.aprilfools.cmds.CommandAprilFools;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

@EventBusSubscriber
public class NeoForgeCommandRegisterEvent {
	@SubscribeEvent
	public static void registerCommands(RegisterCommandsEvent e) {
		CommandAprilFools.register(e.getDispatcher());
	}
}
