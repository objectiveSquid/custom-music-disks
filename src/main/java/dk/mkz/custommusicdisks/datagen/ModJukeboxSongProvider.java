package dk.mkz.custommusicdisks.datagen;

import com.google.gson.JsonObject;
import dk.mkz.custommusicdisks.CustomMusicDisks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.registry.RegistryWrapper;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ModJukeboxSongProvider implements DataProvider {
    private final FabricDataOutput output;

    public ModJukeboxSongProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registries) {
        this.output = output;
    }

    @Override
    public CompletableFuture<?> run(DataWriter writer) {
        List<CompletableFuture<?>> futures = new ArrayList<>();
        Map<String, SongData> songs = Map.of(
                "sigma_boy", new SongData("custom-music-disks:sigma_boy", 160.0F, 15),
                "not_like_us", new SongData("custom-music-disks:not_like_us", 273.0F, 15),
                "italian_brainrot", new SongData("custom-music-disks:italian_brainrot", 44.0F, 15)
        );

        for (var entry : songs.entrySet()) {
            String name = entry.getKey();
            SongData songData = entry.getValue();

            JsonObject json = new JsonObject();

            json.addProperty("comparator_output", songData.comparator());
            json.addProperty("length_in_seconds", songData.length());

            JsonObject description = new JsonObject();
            description.addProperty("translate", "item." + CustomMusicDisks.MOD_ID + "." + name + "_disk.desc");

            json.add("description", description);
            json.addProperty("sound_event", songData.soundEvent());

            Path path = output.getPath()
                    .resolve("data/" + CustomMusicDisks.MOD_ID + "/jukebox_song/" + name + ".json");
            futures.add(DataProvider.writeToPath(writer, json, path));
        }

        // wait for all writes
        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
    }

    @Override
    public String getName() {
        return "Jukebox Song Provider";
    }

    private static record SongData(String soundEvent, float length, int comparator) {}
}
