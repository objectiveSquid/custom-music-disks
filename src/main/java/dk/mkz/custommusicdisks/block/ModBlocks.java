package dk.mkz.custommusicdisks.block;

import dk.mkz.custommusicdisks.CustomMusicDisks;
import dk.mkz.custommusicdisks.block.custom.CustomDiskPlayer;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block CUSTOM_DISK_PLAYER = registerBlock("custom_disk_player", CustomDiskPlayer.class, AbstractBlock.Settings.create()
            .strength(2F, 6F)
            .sounds(BlockSoundGroup.STONE)
            .burnable()
    );

    private static Block registerBlock(String name, Class<? extends Block> blockClass, AbstractBlock.Settings blockSettings) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CustomMusicDisks.MOD_ID, name));
        blockSettings = blockSettings.registryKey(key);
        Block block;
        try {
            block = blockClass.getConstructor(AbstractBlock.Settings.class).newInstance(blockSettings);
        } catch (Exception e) {
            throw new RuntimeException("Failed to register block: " + name);
        }

        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, key, block);
    }

    private static void registerBlockItem(String name, Block block) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CustomMusicDisks.MOD_ID, name));
        BlockItem item = new BlockItem(block, new Item.Settings().registryKey(key));
        Registry.register(Registries.ITEM, key, item);
    }

    public static void registerModBlocks() {
        CustomMusicDisks.LOGGER.info("Registering ModBlocks for " + CustomMusicDisks.MOD_ID);
    }
}
