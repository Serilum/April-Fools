package com.natamus.aprilfools.features;

import com.natamus.aprilfools.config.ConfigHandler;
import com.natamus.aprilfools.data.Variables;
import com.natamus.collective.data.GlobalVariables;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;

public class CowGivesDifferentBuckets {
	public static boolean init(Cow cow, Player player, InteractionHand hand) {
		double differentBucketChance = ConfigHandler.chanceCowGivesDifferentBucket;
		if (differentBucketChance <= 0) {
			return false;
		}

		if (GlobalVariables.random.nextDouble() > differentBucketChance) {
			return false;
		}

		Item otherBucketItem = Variables.otherBuckets.get(GlobalVariables.random.nextInt(Variables.otherBuckets.size()));

		ItemStack handStack = player.getItemInHand(hand);
		ItemStack itemStack = ItemUtils.createFilledResult(handStack, player, otherBucketItem.getDefaultInstance());
		player.setItemInHand(hand, itemStack);

		return true;
	}
}
