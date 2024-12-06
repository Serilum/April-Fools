package com.natamus.aprilfools.mixin;

import com.natamus.aprilfools.features.CowGivesDifferentBuckets;
import com.natamus.aprilfools.util.Util;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = Cow.class, priority = 1001)
public abstract class CowMixin {
	@Inject(method = "mobInteract(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/InteractionHand;)Lnet/minecraft/world/InteractionResult;", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemUtils;createFilledResult(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/item/ItemStack;)Lnet/minecraft/world/item/ItemStack;"), cancellable = true)
	public void mobInteract(Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir) {
		if (!Util.areAprilFoolsFeaturesEnabled()) {
			return;
		}

		Cow cow = (Cow)(Object)this;
		if (CowGivesDifferentBuckets.init(cow, player, hand)) {
			cir.setReturnValue(InteractionResult.SUCCESS);
		}
	}
}