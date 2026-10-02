package com.serilum.aprilfools.events;

import com.serilum.aprilfools.data.Variables;
import com.serilum.aprilfools.util.Util;
import net.minecraft.client.Minecraft;

public class FoolsClientTickEvents {
	private static int clientTickDelay = 0;
	public static void onClientTick(Minecraft mc) {
		if (clientTickDelay > 0) {
			clientTickDelay -= 1;
			return;
		}

		clientTickDelay = 36000;
		Variables.itIsAprilFoolsDay = Util.isAprilFoolsDay();
	}
}
