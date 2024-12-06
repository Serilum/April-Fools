package com.natamus.aprilfools.features;

import com.natamus.aprilfools.config.ConfigHandler;
import com.natamus.aprilfools.util.Util;
import com.natamus.collective.data.GlobalVariables;
import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.FireworkExplosion;
import net.minecraft.world.item.component.Fireworks;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;

public class SpawnCreeperFirework {
	public static boolean init(Creeper creeper) {
		double explodeIntoFireworkChance = Util.setExtraAprilFoolsChance(ConfigHandler.chanceCreepersExplodeIntoFireworks);
		if (explodeIntoFireworkChance <= 0) {
			return false;
		}

		if (GlobalVariables.random.nextDouble() > explodeIntoFireworkChance) {
			return false;
		}

		Vec3 creeperVec = creeper.position();
		Level level = creeper.level();

		ItemStack fireworkItemStack = new ItemStack(Items.FIREWORK_ROCKET, 1);

		List<FireworkExplosion> explosionsList = new ArrayList<FireworkExplosion>();

		boolean hasTrail = true;
		boolean hasTwinkle = true;
		IntList colours = IntList.of(5635925);
		IntList fadeColours = IntList.of(11141120);

		FireworkExplosion fireworkExplosion = new FireworkExplosion(FireworkExplosion.Shape.CREEPER, colours, fadeColours, hasTrail, hasTwinkle);

		explosionsList.add(fireworkExplosion);

		Fireworks fireworks = new Fireworks(0, explosionsList);

		fireworkItemStack.set(DataComponents.FIREWORKS, fireworks);

		FireworkRocketEntity fireworkRocketEntity = new FireworkRocketEntity(level, creeperVec.x, creeperVec.y, creeperVec.z, fireworkItemStack);
		level.addFreshEntity(fireworkRocketEntity);

		creeper.discard();

		return true;
	}
}
