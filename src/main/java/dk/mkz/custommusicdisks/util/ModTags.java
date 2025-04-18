package dk.mkz.custommusicdisks.util;

import dk.mkz.custommusicdisks.CustomMusicDisks;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Items {
        public static final TagKey<Item> CUSTOM_MUSIC_DISKS = createTag("custom_music_disks");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(CustomMusicDisks.MOD_ID, name));
        }
    }
}
