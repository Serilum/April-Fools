package com.natamus.aprilfools.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.natamus.aprilfools.config.ConfigHandler;
import com.natamus.aprilfools.util.Util;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = LivingEntityRenderer.class, priority = 1001)
public abstract class LivingEntityRendererMixin<T extends LivingEntity, M extends EntityModel<T>> extends EntityRenderer<T> {
	protected LivingEntityRendererMixin(EntityRendererProvider.Context context) {
		super(context);
	}

	@Inject(method = "render(Lnet/minecraft/world/entity/LivingEntity;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/PoseStack;scale(FFF)V", ordinal = 0))
	public void render(T livingEntity, float $$1, float $$2, PoseStack poseStack, MultiBufferSource $$4, int $$5, CallbackInfo ci) {
		if (!Util.areAprilFoolsFeaturesEnabled() || !ConfigHandler.makePlayersSleepWithFeetOnPillow) {
			return;
		}

		if (livingEntity.hasPose(Pose.SLEEPING)) {
			poseStack.translate(0.0F, 1.2F, 0.0F);
		}
	}
}