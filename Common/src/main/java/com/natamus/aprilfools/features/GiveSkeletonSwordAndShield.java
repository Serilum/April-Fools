package com.natamus.aprilfools.features;

import com.natamus.aprilfools.config.ConfigHandler;
import com.natamus.collective.data.GlobalVariables;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class GiveSkeletonSwordAndShield {
	public static void init(Level level, Skeleton skeleton) {
		double spawnWithSwordAndShieldChance = ConfigHandler.chanceSkeletonHasSwordAndShield;
		if (spawnWithSwordAndShieldChance <= 0) {
			return;
		}

		if (GlobalVariables.random.nextDouble() > spawnWithSwordAndShieldChance) {
			return;
		}

		skeleton.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(Items.IRON_SWORD, 1));
		skeleton.setItemInHand(InteractionHand.OFF_HAND, new ItemStack(Items.SHIELD, 1));
	}
}
