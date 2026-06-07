package com.natamus.aprilfools.cmds;

import com.mojang.brigadier.CommandDispatcher;
import com.natamus.aprilfools.mixin.WanderingTraderSpawnerInvoker;
import com.natamus.collective.functions.MessageFunctions;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.permissions.Permissions;
import net.minecraft.world.entity.npc.wanderingtrader.WanderingTraderSpawner;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ServerLevelData;

public class CommandAprilFools {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		dispatcher.register(Commands.literal("aprilfools").requires((iCommandSender) -> { return iCommandSender.permissions().hasPermission(Permissions.COMMANDS_ADMIN) && iCommandSender.isPlayer(); })
			.then(Commands.literal("wandering-trader")
			.executes((command) -> {
				CommandSourceStack source = command.getSource();
				Player player = source.getPlayer();
				Level level = player.level();

				if (level.isClientSide()) {
					return 0;
				}

				WanderingTraderSpawner wanderingTraderSpawner = new WanderingTraderSpawner(level.getServer().getDataStorage());
				if (((WanderingTraderSpawnerInvoker)wanderingTraderSpawner).invokeSpawn((ServerLevel)level)) {
					MessageFunctions.sendTranslatableMessage(player, "collective.shared.message.wanderingtraderspawnsuccesful", ChatFormatting.DARK_GREEN);
				}
				else {
					MessageFunctions.sendTranslatableMessage(player, "collective.shared.message.wanderingtraderspawnfailed", ChatFormatting.RED);
				}

				return 1;
			}))
		);
    }
}
