package com.natamus.aprilfools.features;

import com.natamus.aprilfools.config.ConfigHandler;
import com.natamus.collective.data.GlobalVariables;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class SpawnCreeperFirework {
	public static boolean init(Creeper creeper) {
		double explodeIntoFireworkChance = ConfigHandler.chanceCreepersExplodeIntoFireworks;
		if (explodeIntoFireworkChance <= 0) {
			return false;
		}

		if (GlobalVariables.random.nextDouble() > explodeIntoFireworkChance) {
			return false;
		}

		Vec3 creeperVec = creeper.position();
		Level level = creeper.level();

		ItemStack fireworkItemStack = new ItemStack(Items.FIREWORK_ROCKET, 1);

		ListTag explosionsList = new ListTag();

		CompoundTag explosionsTag = new CompoundTag();
		explosionsTag.putByte("Type", (byte) 3);
		explosionsTag.putByte("Flicker", (byte) 0);
		explosionsTag.putByte("Trail", (byte) 1);
		explosionsTag.putIntArray("Colors", new int[] {5635925});
		explosionsTag.putIntArray("FadeColors", new int[] {11141120});

		explosionsList.add(explosionsTag);

		CompoundTag fireworksTag = new CompoundTag();
		fireworksTag.putInt("Flight", 0);
		fireworksTag.put("Explosions", explosionsList);

		fireworkItemStack.addTagElement("Fireworks", fireworksTag);

		FireworkRocketEntity fireworkRocketEntity = new FireworkRocketEntity(level, creeperVec.x, creeperVec.y, creeperVec.z, fireworkItemStack);
		level.addFreshEntity(fireworkRocketEntity);

		creeper.discard();

		return true;
	}
}
