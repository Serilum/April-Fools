package com.natamus.aprilfools.cmds;

import com.mojang.brigadier.CommandDispatcher;
import com.natamus.aprilfools.mixin.WanderingTraderSpawnerMixin;
import com.natamus.collective.functions.MessageFunctions;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.npc.WanderingTraderSpawner;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ServerLevelData;

public class CommandAprilFools {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		dispatcher.register(Commands.literal("aprilfools").requires((iCommandSender) -> { return iCommandSender.hasPermission(2) && iCommandSender.isPlayer(); })
			.then(Commands.literal("wandering-trader")
			.executes((command) -> {
				CommandSourceStack source = command.getSource();
				Player player = source.getPlayer();
				Level level = player.level;

				if (level.isClientSide) {
					return 0;
				}

				WanderingTraderSpawner wanderingTraderSpawner = new WanderingTraderSpawner((ServerLevelData)level.getLevelData());
				if (((WanderingTraderSpawnerMixin.WanderingTraderSpawnerInvoker)wanderingTraderSpawner).invokeSpawn((ServerLevel)level)) {
					MessageFunctions.sendMessage(player, "Wandering trader spawn succesful!", ChatFormatting.DARK_GREEN);
				}
				else {
					MessageFunctions.sendMessage(player, "Wandering trader spawn failed, try again.", ChatFormatting.RED);
				}

				return 1;
			}))
		);
    }
}
