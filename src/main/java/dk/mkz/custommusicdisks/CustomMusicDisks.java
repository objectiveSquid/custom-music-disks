package dk.mkz.custommusicdisks;

import dk.mkz.custommusicdisks.block.ModBlocks;
import dk.mkz.custommusicdisks.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomMusicDisks implements ModInitializer {
	public static final String MOD_ID = "custom-music-disks";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}