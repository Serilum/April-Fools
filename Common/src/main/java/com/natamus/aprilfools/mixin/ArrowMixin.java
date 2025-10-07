package com.natamus.aprilfools.mixin;

import net.minecraft.world.entity.projectile.Arrow;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = Arrow.class, priority = 1001)
public abstract class ArrowMixin { // extends AbstractArrow {
	/*protected ArrowMixin(EntityType<? extends AbstractArrow> $$0, Level $$1) { super($$0, $$1); }

	@Shadow
	protected abstract void updateColor();

	@Inject(method = "setPickupItemStack", at = @At(value = "HEAD"), cancellable = true)
	protected void getPickupItem(ItemStack itemStack, CallbackInfo ci) {
		Arrow arrow = (Arrow)(Object)this;
		if (arrow.getTags().contains(Reference.MOD_ID + ".foolsarrow")) {
			ci.cancel();
		}
	}

	@Inject(method = "setPotionContents", at = @At(value = "HEAD"))
	public void setEffectsFromItem(PotionContents $$0, CallbackInfo ci) {
		ItemStack itemStack = ((Arrow)(Object)this).getPickupItemStackOrigin();
		if (itemStack.is(Items.TIPPED_ARROW)) {
			((Arrow)(Object)this).addTag(Reference.MOD_ID + ".istipped");
		}
	}*/
}