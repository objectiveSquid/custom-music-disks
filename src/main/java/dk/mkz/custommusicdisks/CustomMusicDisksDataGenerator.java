package dk.mkz.custommusicdisks;

import dk.mkz.custommusicdisks.datagen.ModItemTagProvider;
import dk.mkz.custommusicdisks.datagen.ModJukeboxSongProvider;
import dk.mkz.custommusicdisks.datagen.ModModelProvider;
import dk.mkz.custommusicdisks.datagen.ModSoundsProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class CustomMusicDisksDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModJukeboxSongProvider::new);
		pack.addProvider(ModSoundsProvider::new);
	}
}
