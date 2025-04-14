package dk.mkz.custommusicdisks.item;

import dk.mkz.custommusicdisks.CustomMusicDisks;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item CUSTOM_DISK = registerItem("custom_disk", Item.class, new Item.Settings());

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
