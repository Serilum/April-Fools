package com.natamus.aprilfools.mixin;

import com.natamus.aprilfools.features.SpawnWanderingTraderDonkeys;
import com.natamus.aprilfools.util.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.npc.WanderingTraderSpawner;
import net.minecraft.world.level.LevelReader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = WanderingTraderSpawner.class, priority = 1001)
public abstract class WanderingTraderSpawnerMixin {
	@Shadow
	protected abstract BlockPos findSpawnPositionNear(LevelReader $$0, BlockPos $$1, int $$2);

	@Inject(method = "tryToSpawnLlamaFor(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/npc/WanderingTrader;I)V", at = @At(value = "HEAD"), cancellable = true)
	private void tryToSpawnLlamaFor(ServerLevel serverLevel, WanderingTrader wanderingTrader, int a, CallbackInfo ci) {
		if (!Util.areAprilFoolsFeaturesEnabled()) {
			return;
		}

		BlockPos blockPos = findSpawnPositionNear(serverLevel, wanderingTrader.blockPosition(), a);
		if (SpawnWanderingTraderDonkeys.init(serverLevel, blockPos, wanderingTrader)) {
			ci.cancel();
		}
	}

	@Mixin(WanderingTraderSpawner.class)
	public interface WanderingTraderSpawnerInvoker {
		@Invoker("spawn")
		boolean invokeSpawn(ServerLevel serverLevel);
	}
}