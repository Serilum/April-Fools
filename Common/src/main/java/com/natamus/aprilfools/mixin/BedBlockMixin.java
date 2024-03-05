package com.natamus.aprilfools.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = BedBlock.class, priority = 1001)
public abstract class BedBlockMixin {
	@Inject(method = "getBedOrientation(Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;)Lnet/minecraft/core/Direction;", at = @At(value = "HEAD"), cancellable = true)
	private static void getBedOrientation(BlockGetter blockGetter, BlockPos blockPos, CallbackInfoReturnable<Direction> cir) {
        BlockState blockState = blockGetter.getBlockState(blockPos);
        cir.setReturnValue(blockState.getBlock() instanceof BedBlock ? blockState.getValue(BedBlock.FACING).getClockWise().getClockWise() : null);
	}
}