package com.natamus.aprilfools.events;

import com.natamus.aprilfools.data.Variables;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class FoolsBlockEvents {
	public static boolean onBlockBreak(Level level, Player player, BlockPos blockPos, BlockState blockState, BlockEntity blockEntity) {
		if (level.isClientSide) {
			return true;
		}

		if (blockState.getBlock().equals(Blocks.POTATOES)) {
			Variables.potatoBlocksBroken.add(blockPos.immutable());
		}
		return true;
	}
}
