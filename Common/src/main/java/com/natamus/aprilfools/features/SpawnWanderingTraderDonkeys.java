package com.natamus.aprilfools.features;

import com.natamus.aprilfools.config.ConfigHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.animal.horse.Donkey;
import net.minecraft.world.entity.npc.WanderingTrader;

public class SpawnWanderingTraderDonkeys {
	public static boolean init(ServerLevel serverLevel, BlockPos blockPos, WanderingTrader wanderingTrader) {
		if (!ConfigHandler.makeWanderingTraderSpawnWithDonkeys) {
			return false;
		}

		Donkey donkey = EntityType.DONKEY.spawn(serverLevel, blockPos, EntitySpawnReason.EVENT);
		if (donkey != null) {
			donkey.setLeashedTo(wanderingTrader, true);
			return true;
		}

		return false;
	}
}
