package com.natamus.aprilfools.config;

import com.natamus.aprilfools.util.Reference;
import com.natamus.collective.config.DuskConfig;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConfigHandler extends DuskConfig {
	public static HashMap<String, List<String>> configMetaData = new HashMap<String, List<String>>();

	@Entry public static boolean enableOnlyOnApril1st = true;
	@Entry(min = 0.0, max = 1000.0) public static double april1stChanceMultiplier = 0.0;
	@Entry public static boolean makeCatsBarkAndDogsMeow = true;
	@Entry public static boolean makePlayersSleepWithFeetOnPillow = true;
	@Entry public static boolean makeWanderingTraderSpawnWithDonkeys = true;
	@Entry(min = 0.0, max = 1.0) public static double chanceCowGivesDifferentBucket = 0.2;
	@Entry(min = 0.0, max = 1.0) public static double chanceCreepersExplodeIntoFireworks = 0.5;
	@Entry(min = 0.0, max = 1.0) public static double chancePotatoCropDropsPoisonous = 1.0;
	@Entry(min = 0.0, max = 1.0) public static double chanceSkeletonHasSwordAndShield = 0.25;
	@Entry(min = 0.0, max = 1.0) public static double chanceNormalArrowFiredHasRandomEffect = 0.33;

	public static void initConfig() {
		configMetaData.put("enableOnlyOnApril1st", Arrays.asList(
			"If the april fools features should only be enabled on April 1st. If set to false, they will always be enabled."
		));
		configMetaData.put("april1stChanceMultiplier", Arrays.asList(
			"Can be used to increase the chance of features happening on April 1st. So for example you can set 'enableOnlyOnApril1st' to false, 'chanceCreepersExplodeIntoFireworks' to 0.01 and 'april1stChanceMultiplier' to 25.0. This way a creeper would 1/100 launch a firework rocket outside of April 1st, and 1/4 on April Fools' day."
		));
		configMetaData.put("makeCatsBarkAndDogsMeow", Arrays.asList(
			"If cats should bark and dogs should meow."
		));
		configMetaData.put("makePlayersSleepWithFeetOnPillow", Arrays.asList(
			"If players should sleep in beds the opposite way, with their feet on the pillow."
		));
		configMetaData.put("makeWanderingTraderSpawnWithDonkeys", Arrays.asList(
			"If the Wandering Trader should spawn with two donkeys instead of llamas."
		));
		configMetaData.put("chanceCowGivesDifferentBucket", Arrays.asList(
			"The chance that a cow gives, instead of a bucket of milk, a bucket of lava or water. Set to 0 to disable."
		));
		configMetaData.put("chanceCreepersExplodeIntoFireworks", Arrays.asList(
			"If creepers should, instead of exploding, spawn a firework rocket with a creeper pattern. By default a 50% chance. Set to 0 to disable."
		));
		configMetaData.put("chancePotatoCropDropsPoisonous", Arrays.asList(
			"The chance a potato dropped by a potato plant should be made poisonous on harvest."
		));
		configMetaData.put("chanceSkeletonHasSwordAndShield", Arrays.asList(
			"The chance a skeleton spawns with a sword and a shield instead of a bow. Set to 0 to disable."
		));
		configMetaData.put("chanceNormalArrowFiredHasRandomEffect", Arrays.asList(
			"The chance an arrow fired by a player has a random potion effect attached to it. Set to 0 to disable."
		));

		DuskConfig.init(Reference.NAME, Reference.MOD_ID, ConfigHandler.class);
	}
}