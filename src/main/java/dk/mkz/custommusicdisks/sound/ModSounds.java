package dk.mkz.custommusicdisks.sound;

import dk.mkz.custommusicdisks.CustomMusicDisks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent CUSTOM_DISK_SOUND = registerSoundEvent("custom_disk_sound");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(CustomMusicDisks.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        CustomMusicDisks.LOGGER.info("Registering ModSounds for " + CustomMusicDisks.MOD_ID);
    }
}
