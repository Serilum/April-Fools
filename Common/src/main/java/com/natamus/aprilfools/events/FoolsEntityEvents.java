package com.natamus.aprilfools.events;

import com.natamus.aprilfools.features.GiveSkeletonSwordAndShield;
import com.natamus.aprilfools.features.MakePotatoPoisonous;
import com.natamus.aprilfools.util.Util;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class FoolsEntityEvents {
	public static void onSpawn(Level level, Entity entity) {
		if (!Util.areAprilFoolsFeaturesEnabled()) {
			return;
		}

		if (level.isClientSide) {
			return;
		}

		if (entity instanceof Arrow) {
			//GiveArrowRandomEffect.init(level, (Arrow)entity);
		}
		else if (entity instanceof ItemEntity) {
			ItemEntity itemEntity = (ItemEntity)entity;
			ItemStack itemStack = itemEntity.getItem();
			if (itemStack.getItem().equals(Items.POTATO)) {
				MakePotatoPoisonous.init(level, itemEntity, itemStack);
			}
		}
		else if (entity instanceof Skeleton) {
			GiveSkeletonSwordAndShield.init(level, (Skeleton)entity);
		}
	}
}
