package dk.mkz.custommusicdisks.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import dk.mkz.custommusicdisks.CustomMusicDisks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.registry.RegistryWrapper;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModSoundsProvider implements DataProvider {
    private final FabricDataOutput output;

    public ModSoundsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registries) {
        this.output = output;
    }

    @Override
    public CompletableFuture<?> run(DataWriter writer) {
        List<SoundData> sounds = List.of(
            new SoundData("sigma_boy", true),
            new SoundData("not_like_us", true),
            new SoundData("italian_brainrot", true)
        );

        JsonObject json = new JsonObject();

        for (SoundData soundData : sounds) {
            JsonObject soundEntry = new JsonObject();

            JsonArray soundsArray = new JsonArray();
            JsonObject soundObject = new JsonObject();
            soundObject.addProperty("name", CustomMusicDisks.MOD_ID + ":" + soundData.soundEvent);
            soundObject.addProperty("stream", soundData.stream);
            soundsArray.add(soundObject);

            soundEntry.add("sounds", soundsArray);

            json.add(soundData.soundEvent, soundEntry);
        }

        Path path = output.getPath()
                .resolve("assets/" + CustomMusicDisks.MOD_ID + "/sounds.json");

        // wait for write
        return DataProvider.writeToPath(writer, json, path);
    }

    @Override
    public String getName() {
        return "Sounds Provider (assets/MOD_ID/sounds.json)";
    }

    private static record SoundData(String soundEvent, Boolean stream) {}
}
