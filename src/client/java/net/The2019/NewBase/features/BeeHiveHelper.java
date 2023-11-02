package net.The2019.NewBase.features;

import net.The2019.NewBase.render.WorldRender;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.minecraft.block.entity.BeehiveBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;

import java.util.ArrayList;
import java.util.List;

public class BeeHiveHelper {

    private static final MinecraftClient mc = MinecraftClient.getInstance();
    private static final float[] colorComponents = {0.0f, 0.0f, 0.0f};

    private static final int RENDER_INTERVAL = 20;

    public static List<BlockEntity> getBlockEntitiesInRange(ClientWorld world, int radius) {
        List<BlockEntity> blockEntities = new ArrayList<>();

        if (world == null || mc.player == null) {
            return blockEntities;
        }

        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    BlockPos pos = mc.player.getBlockPos().add(x, y, z);
                    BlockEntity blockEntity = world.getBlockEntity(pos);

                    if (blockEntity != null) {
                        blockEntities.add(blockEntity);
                    }
                }
            }
        }

        return blockEntities;
    }

    public static void register() {
        WorldRenderEvents.END.register(context -> {
            if (mc.player != null && (mc.player.age % RENDER_INTERVAL) == 0) {
                for (BlockEntity blockEntity : getBlockEntitiesInRange(context.world(), 20)) {
                    if (blockEntity instanceof BeehiveBlockEntity) {
                        BlockPos blockEntityPos = blockEntity.getPos();
                        WorldRender.renderOutline(context, new Box(blockEntityPos), colorComponents, 5, true);
                    }
                }
            }
        });
    }
}