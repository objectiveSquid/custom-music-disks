package dk.mkz.custommusicdisks.datagen;

import dk.mkz.custommusicdisks.item.ModItems;
import dk.mkz.custommusicdisks.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.CUSTOM_MUSIC_DISKS)
                .add(ModItems.SIGMA_BOY_DISK)
                .add(ModItems.NOT_LIKE_US_DISK)
                .add(ModItems.ITALIAN_BRAINROT_DISK)
                .add(ModItems.HELLO_MR_PUTIN_DISK)
                .add(ModItems.BALLIN_DISK)
                .add(ModItems.IPHONE_RADAR_DISK)
                .add(ModItems.IPHONE_RADAR_WW_DISK);
    }
}
