package com.natamus.aprilfools.data;

import com.natamus.aprilfools.util.Reference;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class Sounds {
    public static final ResourceLocation FOOLS_CAT_AMBIENT_LOCATION = ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "cat.ambient");
	public static final ResourceLocation FOOLS_WOLF_AMBIENT_LOCATION = ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "wolf.ambient");
    public static SoundEvent FOOLS_CAT_SOUND_EVENT = SoundEvent.createVariableRangeEvent(FOOLS_CAT_AMBIENT_LOCATION);
	public static SoundEvent FOOLS_WOLF_SOUND_EVENT = SoundEvent.createVariableRangeEvent(FOOLS_WOLF_AMBIENT_LOCATION);
}
