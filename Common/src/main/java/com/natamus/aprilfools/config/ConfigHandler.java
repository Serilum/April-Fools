package com.natamus.aprilfools.config;

import com.natamus.collective.config.DuskConfig;
import com.natamus.aprilfools.util.Reference;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConfigHandler extends DuskConfig {
	public static HashMap<String, List<String>> configMetaData = new HashMap<String, List<String>>();

	@Entry public static boolean enableOnlyOnApril1st = true;
	@Entry public static boolean makeAllPotatoCropDropsPoisonous = true;
	@Entry public static boolean makeCatsBarkAndDogsMeow = true;
	@Entry(min = 0.0, max = 1.0) public static double chanceCowGivesDifferentBucket = 0.2;
	@Entry(min = 0.0, max = 1.0) public static double chanceCreepersExplodeIntoFireworks = 0.5;
	@Entry(min = 0.0, max = 1.0) public static double chanceSkeletonHasSwordAndShield = 0.25;
	@Entry(min = 0.0, max = 1.0) public static double chanceNormalArrowFiredHasRandomEffect = 0.33;
	@Entry public static boolean makeWanderingTraderSpawnWithDonkeys = true;
	@Entry public static boolean makePlayersSleepWithFeetOnPillow = true;

	public static void initConfig() {
		configMetaData.put("enableOnlyOnApril1st", Arrays.asList(
			"If the april fools features should only be enabled on April 1st. If set to false, they will always be enabled."
		));
		configMetaData.put("makeAllPotatoCropDropsPoisonous", Arrays.asList(
			"If all potatoes which are dropped by a potato plant should be made poisonous on harvest."
		));
		configMetaData.put("makeCatsBarkAndDogsMeow", Arrays.asList(
			"If cats should bark and dogs should meow."
		));
		configMetaData.put("chanceCowGivesDifferentBucket", Arrays.asList(
			"The chance that a cow gives, instead of a bucket of milk, a bucket of lava or water. Set to 0 to disable."
		));
		configMetaData.put("chanceCreepersExplodeIntoFireworks", Arrays.asList(
			"If creepers should, instead of exploding, spawn a firework rocket with a creeper pattern. By default a 50% chance. Set to 0 to disable."
		));
		configMetaData.put("chanceSkeletonHasSwordAndShield", Arrays.asList(
			"The chance a skeleton spawns with a sword and a shield instead of a bow. Set to 0 to disable."
		));
		configMetaData.put("chanceNormalArrowFiredHasRandomEffect", Arrays.asList(
			"The chance an arrow fired by a player has a random potion effect attached to it. Set to 0 to disable."
		));
		configMetaData.put("makeWanderingTraderSpawnWithDonkeys", Arrays.asList(
			"If the Wandering Trader should spawn with two donkeys instead of llamas."
		));
		configMetaData.put("makePlayersSleepWithFeetOnPillow", Arrays.asList(
			"If players should sleep in beds the opposite way, with their feet on the pillow."
		));

		DuskConfig.init(Reference.NAME, Reference.MOD_ID, ConfigHandler.class);
	}
}