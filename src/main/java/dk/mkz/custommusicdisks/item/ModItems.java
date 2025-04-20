package dk.mkz.custommusicdisks.item;

import dk.mkz.custommusicdisks.CustomMusicDisks;
import dk.mkz.custommusicdisks.sound.ModSounds;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item SIGMA_BOY_DISK = registerMusicDisk("sigma_boy_disk", ModSounds.SIGMA_BOY_KEY);
    public static final Item NOT_LIKE_US_DISK = registerMusicDisk("not_like_us_disk", ModSounds.NOT_LIKE_US_KEY);
    public static final Item ITALIAN_BRAINROT_DISK = registerMusicDisk("italian_brainrot_disk", ModSounds.ITALIAN_BRAINROT_KEY);
    public static final Item HELLO_MR_PUTIN_DISK = registerMusicDisk("hello_mr_putin_disk", ModSounds.HELLO_MR_PUTIN_KEY);
    public static final Item BALLIN_DISK = registerMusicDisk("ballin_disk", ModSounds.BALLIN_KEY);
    public static final Item IPHONE_RADAR_DISK = registerMusicDisk("iphone_radar_disk", ModSounds.IPHONE_RADAR_KEY);
    public static final Item IPHONE_RADAR_WW_DISK = registerMusicDisk("iphone_radar_ww_disk", ModSounds.IPHONE_RADAR_WW_KEY);

    private static Item registerMusicDisk(String name, RegistryKey<JukeboxSong> soundKey) {
        return registerItem(name, Item.class, new Item.Settings().jukeboxPlayable(soundKey).maxCount(1));
    }

    private static Item registerItem(String name, Class<? extends Item> itemClass, Item.Settings itemSettings) {
        itemSettings = itemSettings.registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CustomMusicDisks.MOD_ID,name)));
        Item item;
        try {
            item = itemClass.getConstructor(Item.Settings.class).newInstance(itemSettings);
        } catch (Exception error) {
            throw new RuntimeException("Failed to register item: " + name);
        }

        return Registry.register(Registries.ITEM, Identifier.of(CustomMusicDisks.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CustomMusicDisks.LOGGER.info("Registering ModItems for " + CustomMusicDisks.MOD_ID);
    }
}
