package dk.mkz.custommusicdisks.item;

import dk.mkz.custommusicdisks.CustomMusicDisks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item CUSTOM_DISK = registerItem("custom_disk", new Item.Settings());

    private static Item registerItem(String name, Item.Settings itemSettings) {
        itemSettings = itemSettings.registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CustomMusicDisks.MOD_ID,name)));
        return Registry.register(Registries.ITEM, Identifier.of(CustomMusicDisks.MOD_ID, name), new Item(itemSettings));
    }

    public static void registerModItems() {
        CustomMusicDisks.LOGGER.info("Registering ModItems for " + CustomMusicDisks.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries -> {
            entries.add(CUSTOM_DISK);
        });
    }
}
