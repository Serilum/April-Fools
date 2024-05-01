package com.natamus.aprilfools.mixin;

import com.natamus.aprilfools.config.ConfigHandler;
import com.natamus.aprilfools.util.Util;
import net.minecraft.client.Camera;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = Camera.class, priority = 1001)
public abstract class CameraMixin {
	@Shadow protected abstract void move(double $$0, double $$1, double $$2);

	@Inject(method = "setup(Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/world/entity/Entity;ZZF)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Camera;move(DDD)V", ordinal = 1))
	public void setup(BlockGetter blockGetter, Entity entity, boolean $$2, boolean $$3, float $$4, CallbackInfo ci) {
		if (!Util.areAprilFoolsFeaturesEnabled() || !ConfigHandler.makePlayersSleepWithFeetOnPillow) {
			return;
		}

		this.move(-1.0, 0.0, 0.0);
	}
}