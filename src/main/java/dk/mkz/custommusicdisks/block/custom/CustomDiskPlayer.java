package dk.mkz.custommusicdisks.block.custom;

import dk.mkz.custommusicdisks.CustomMusicDisks;
import dk.mkz.custommusicdisks.item.ModItems;
import dk.mkz.custommusicdisks.sound.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CustomDiskPlayer extends Block {
    @Nullable
    private Item containedItem = null;

    public CustomDiskPlayer(Settings settings) {
        super(settings);
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (this.containedItem != null && !world.isClient()) {
            // if there is no disk, we should not drop one
            ServerWorld serverWorld = (ServerWorld) world;
            ItemStack diskStack = new ItemStack(this.containedItem);
            diskStack.setCount(1);
            ItemEntity itemEntity = new ItemEntity(serverWorld, pos.getX(), pos.getY(), pos.getZ(), diskStack);
            serverWorld.spawnEntity(itemEntity);
            this.containedItem = null;
        }

        return super.onBreak(world, pos, state, player);
    }

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        CustomMusicDisks.LOGGER.info("pressed");
        if (containedItem != null && !world.isClient()) {
            // spit out previous disk
            ServerWorld serverWorld = (ServerWorld) world;
            ItemStack diskStack = new ItemStack(this.containedItem);
            diskStack.setCount(1);
            ItemEntity itemEntity = new ItemEntity(serverWorld, pos.getX() + 0.5F, pos.getY() + 1F, pos.getZ() + 0.5F, diskStack);
            serverWorld.spawnEntity(itemEntity);
            containedItem = null;
            return ActionResult.SUCCESS;
        }
        if (!stack.getName().toString().equals(ModItems.CUSTOM_DISK.getName().toString()))
            return ActionResult.PASS;

        if (!world.isClient()) {
            this.containedItem = stack.getItem();
            stack.decrement(1);
            CustomMusicDisks.LOGGER.info("Custom disk inserted");
        }
        world.playSound(null, pos, ModSounds.CUSTOM_DISK_SOUND, SoundCategory.MUSIC);

        return ActionResult.SUCCESS;
    }
}
