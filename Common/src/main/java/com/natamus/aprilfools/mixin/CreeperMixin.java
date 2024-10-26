package com.natamus.aprilfools.mixin;

import com.natamus.aprilfools.features.SpawnCreeperFirework;
import com.natamus.aprilfools.util.Util;
import net.minecraft.world.entity.monster.Creeper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = Creeper.class, priority = 1001)
public abstract class CreeperMixin {
	@Inject(method = "explodeCreeper()V", at = @At(value = "HEAD"), cancellable = true)
	private void explodeCreeper(CallbackInfo ci) {
		if (!Util.areAprilFoolsFeaturesEnabled()) {
			return;
		}

		if (SpawnCreeperFirework.init((Creeper)(Object)this)) {
			ci.cancel();
		}
	}
}