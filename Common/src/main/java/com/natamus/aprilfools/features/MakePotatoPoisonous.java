package com.natamus.aprilfools.features;

import com.natamus.aprilfools.config.ConfigHandler;
import com.natamus.aprilfools.data.Variables;
import com.natamus.aprilfools.util.Util;
import com.natamus.collective.data.GlobalVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

public class MakePotatoPoisonous {
	public static void init(Level level, ItemEntity itemEntity, ItemStack itemStack) {
		double potatoIsPoisonousChance = Util.setExtraAprilFoolsChance(ConfigHandler.chancePotatoCropDropsPoisonous);
		if (potatoIsPoisonousChance <= 0) {
			return;
		}

		if (GlobalVariables.random.nextDouble() > potatoIsPoisonousChance) {
			return;
		}

		BlockPos blockPos = itemEntity.blockPosition();
		if (!Variables.potatoBlocksBroken.contains(blockPos)) {
			return;
		}

		boolean foundMorePotatoes = false;
		for (Entity entity : level.getEntities(null, new AABB(blockPos.getX()-1, blockPos.getY()-1, blockPos.getZ()-1, blockPos.getX()+1, blockPos.getY()+1, blockPos.getZ()+1))) {
			if (entity instanceof ItemEntity) {
				if (((ItemEntity)entity).getItem().getItem().equals(Items.POTATO)) {
					foundMorePotatoes = true;
					break;
				}
			}
		}

		if (!foundMorePotatoes) {
			Variables.potatoBlocksBroken.remove(blockPos);
		}

		ItemStack poisonousPotatoStack = new ItemStack(Items.POISONOUS_POTATO, itemStack.getCount());
		itemEntity.setItem(poisonousPotatoStack);
	}
}
