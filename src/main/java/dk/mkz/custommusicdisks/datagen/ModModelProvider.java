package dk.mkz.custommusicdisks.datagen;

import dk.mkz.custommusicdisks.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.SIGMA_BOY_DISK, Models.GENERATED);
        itemModelGenerator.register(ModItems.NOT_LIKE_US_DISK, Models.GENERATED);
        itemModelGenerator.register(ModItems.ITALIAN_BRAINROT_DISK, Models.GENERATED);
    }
}
