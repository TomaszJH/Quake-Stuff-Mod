package tomaszjh.quakeadditions.weapons.registries;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.registry.Registry;
import tomaszjh.quakeadditions.QuakeAdditions;

public class SoundRegistry {

        public static final SoundEvent PLASMA_GUN_FIRE = register("item.plasma_gun.fire");

        private static SoundEvent register(final String soundName) {
            final ResourceLocation soundID = new ResourceLocation(QuakeAdditions.MOD_ID, soundName);
            return new SoundEvent(soundID).setRegistryName(soundID);
        }

}
