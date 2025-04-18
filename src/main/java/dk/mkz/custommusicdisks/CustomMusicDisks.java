package dk.mkz.custommusicdisks;

import dk.mkz.custommusicdisks.item.ModItemGroups;
import dk.mkz.custommusicdisks.item.ModItems;
import dk.mkz.custommusicdisks.sound.ModSounds;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomMusicDisks implements ModInitializer {
	public static final String MOD_ID = "custom-music-disks";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModSounds.registerSounds();
	}
}