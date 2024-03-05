package com.natamus.aprilfools.mixin;

import com.natamus.aprilfools.util.Reference;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = Arrow.class, priority = 1001)
public abstract class ArrowMixin {
	@Inject(method = "getPickupItem()Lnet/minecraft/world/item/ItemStack;", at = @At(value = "HEAD"), cancellable = true)
	protected void getPickupItem(CallbackInfoReturnable<ItemStack> cir) {
		Arrow arrow = (Arrow)(Object)this;
		if (arrow.getTags().contains(Reference.MOD_ID + ".foolsarrow")) {
			arrow.remove(Entity.RemovalReason.DISCARDED);

			cir.setReturnValue(new ItemStack(Items.ARROW, 1));
		}
	}

	@Inject(method = "setEffectsFromItem(Lnet/minecraft/world/item/ItemStack;)V", at = @At(value = "HEAD"))
	public void setEffectsFromItem(ItemStack itemStack, CallbackInfo ci) {
		if (itemStack.is(Items.TIPPED_ARROW)) {
			((Arrow)(Object)this).addTag(Reference.MOD_ID + ".istipped");
		}
	}
}