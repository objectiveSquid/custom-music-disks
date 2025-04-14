package dk.mkz.custommusicdisks.item;

import dk.mkz.custommusicdisks.CustomMusicDisks;
import dk.mkz.custommusicdisks.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup CUSTOM_MUSIC_DISKS_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(CustomMusicDisks.MOD_ID, "custom_music_disks"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.CUSTOM_DISK))
                    .displayName(Text.translatable("itemgroup.custom-music-disks.custom_music_disks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.CUSTOM_DISK);
                        entries.add(ModBlocks.CUSTOM_DISK_PLAYER);
                    })
                    .build()
    );

    public static void registerItemGroups() {
        CustomMusicDisks.LOGGER.info("Registering ModItemGroups for " + CustomMusicDisks.MOD_ID);
    }
}
