package dk.mkz.custommusicdisks.sound;

import dk.mkz.custommusicdisks.CustomMusicDisks;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent SIGMA_BOY_SOUND = registerSoundEvent("sigma_boy");
    public static final RegistryKey<JukeboxSong> SIGMA_BOY_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(CustomMusicDisks.MOD_ID, "sigma_boy"));

    public static final SoundEvent NOT_LIKE_US_SOUND = registerSoundEvent("not_like_us");
    public static final RegistryKey<JukeboxSong> NOT_LIKE_US_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(CustomMusicDisks.MOD_ID, "not_like_us"));

    public static final SoundEvent ITALIAN_BRAINROT_SOUND = registerSoundEvent("italian_brainrot");
    public static final RegistryKey<JukeboxSong> ITALIAN_BRAINROT_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(CustomMusicDisks.MOD_ID, "italian_brainrot"));

    public static final SoundEvent HELLO_MR_PUTIN_SOUND = registerSoundEvent("hello_mr_putin");
    public static final RegistryKey<JukeboxSong> HELLO_MR_PUTIN_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(CustomMusicDisks.MOD_ID, "hello_mr_putin"));

    public static final SoundEvent BALLIN_SOUND = registerSoundEvent("ballin");
    public static final RegistryKey<JukeboxSong> BALLIN_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(CustomMusicDisks.MOD_ID, "ballin"));

    public static final SoundEvent IPHONE_RADAR_SOUND = registerSoundEvent("iphone_radar");
    public static final RegistryKey<JukeboxSong> IPHONE_RADAR_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(CustomMusicDisks.MOD_ID, "iphone_radar"));

    public static final SoundEvent IPHONE_RADAR_WW_SOUND = registerSoundEvent("iphone_radar_ww");
    public static final RegistryKey<JukeboxSong> IPHONE_RADAR_WW_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(CustomMusicDisks.MOD_ID, "iphone_radar_ww"));

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(CustomMusicDisks.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        CustomMusicDisks.LOGGER.info("Registering ModSounds for " + CustomMusicDisks.MOD_ID);
    }
}
