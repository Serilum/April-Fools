package com.natamus.aprilfools.data;

import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Variables {
	public static boolean itIsAprilFoolsDay = false;

	public static final Logger logger = LogUtils.getLogger();

	public static final List<BlockPos> potatoBlocksBroken = new ArrayList<BlockPos>();
	public static final List<Item> otherBuckets = new ArrayList<Item>(Arrays.asList(Items.LAVA_BUCKET, Items.WATER_BUCKET));
}
