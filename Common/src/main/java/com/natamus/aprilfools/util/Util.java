package com.natamus.aprilfools.util;

import com.natamus.aprilfools.config.ConfigHandler;
import com.natamus.aprilfools.data.Variables;
import com.natamus.collective.data.GlobalVariables;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.Level;

import java.time.LocalDate;
import java.util.Set;

public class Util {
	public static boolean areAprilFoolsFeaturesEnabled() {
		if (!ConfigHandler.enableOnlyOnApril1st) {
			return true;
		}

		return Variables.itIsAprilFoolsDay;
	}

	public static boolean isAprilFoolsDay() {
		LocalDate today = LocalDate.now();
		return today.getMonthValue() == 4 && today.getDayOfMonth() == 1;
	}

	public static double setExtraAprilFoolsChance(double chance) {
		if (!Variables.itIsAprilFoolsDay) {
			return chance;
		}

		double multiplier = ConfigHandler.april1stChanceMultiplier;
		if (multiplier <= 0.0) {
			return chance;
		}

		return chance * multiplier;
	}

	public static MobEffect getRandomMobEffect(Level level) {
		Registry<MobEffect> mobEffectRegistry = level.registryAccess().registryOrThrow(Registries.MOB_EFFECT);

		return mobEffectRegistry.get(getRandomSetElement(mobEffectRegistry.keySet()));
	}

	static <E> E getRandomSetElement(Set<E> set) {
		return set.stream().skip(GlobalVariables.random.nextInt(set.size())).findFirst().orElse(null);
	}
}
