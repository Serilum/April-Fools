package com.natamus.aprilfools.util;

import com.natamus.aprilfools.config.ConfigHandler;

import java.time.LocalDate;

public class Util {
	public static boolean areAprilFoolsFeaturesEnabled() {
		if (!ConfigHandler.enableOnlyOnApril1st) {
			return true;
		}

		LocalDate today = LocalDate.now();
		return today.getMonthValue() == 4 && today.getDayOfMonth() == 1;
	}
}
