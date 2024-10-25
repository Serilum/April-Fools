package com.natamus.aprilfools.features;

import com.natamus.aprilfools.config.ConfigHandler;
import com.natamus.aprilfools.util.Reference;
import com.natamus.aprilfools.util.Util;
import com.natamus.collective.data.GlobalVariables;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.level.Level;

public class GiveArrowRandomEffect {
	public static void init(Level level, Arrow arrow) {
		if (!(arrow.getOwner() instanceof Player)) {
			return;
		}

		if (arrow.getTags().contains(Reference.MOD_ID + ".istipped")) {
			return;
		}

		double arrowHasRandomEffectChance = Util.setExtraAprilFoolsChance(ConfigHandler.chanceNormalArrowFiredHasRandomEffect);
		if (arrowHasRandomEffectChance <= 0) {
			return;
		}

		if (GlobalVariables.random.nextDouble() > arrowHasRandomEffectChance) {
			return;
		}

		Holder<MobEffect> mobEffectHolder = Util.getRandomMobEffect(level);
		if (mobEffectHolder != null) {
			arrow.addEffect(new MobEffectInstance(mobEffectHolder));
			arrow.addTag(Reference.MOD_ID + ".foolsarrow");
		}
	}
}
