package com.natamus.aprilfools.events;

import com.natamus.aprilfools.data.Variables;
import com.natamus.aprilfools.util.Util;
import net.minecraft.server.MinecraftServer;

public class FoolsServerTickEvents {
	private static int serverTickDelay = 0;

	public static void onServerTick(MinecraftServer server) {
		if (serverTickDelay > 0) {
			serverTickDelay -= 1;
			return;
		}

		serverTickDelay = 36000;
		Variables.itIsAprilFoolsDay = Util.isAprilFoolsDay();
	}
}
