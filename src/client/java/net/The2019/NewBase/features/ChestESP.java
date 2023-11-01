package net.The2019.NewBase.features;

import net.The2019.NewBase.render.WorldRender;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class ChestESP {
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    private static final float[] colorComponents = {0.0f, 0.0f, 0.0f};

    private static final int RENDER_INTERVAL = 40;
    private static int ticksSinceLastRender = 0;

    public static void render() {
        WorldRenderEvents.END.register(context -> {
            if (mc.player != null) {
                ticksSinceLastRender++;

                if (ticksSinceLastRender >= RENDER_INTERVAL) {
                    for (BlockEntity blockEntity : getBlockEntitiesInRenderDistance()) {
                        if (blockEntity instanceof ChestBlockEntity) {
                            BlockPos entityPos = blockEntity.getPos();
                            WorldRender.renderOutline(context, Box.from(Vec3d.of(entityPos)), colorComponents, 5, true);
                        }
                    }
                    ticksSinceLastRender = 0;
                }
            }
        });
    }

    public static List<BlockEntity> getBlockEntitiesInRenderDistance() {
        List<BlockEntity> blockEntities = new ArrayList<>();
        MinecraftClient mc = MinecraftClient.getInstance();
        World world = mc.world;

        if (world == null) {
            return blockEntities;
        }

        int renderDistance = mc.options.getViewDistance().getValue();

        BlockPos playerPos = new BlockPos((int) mc.player.getX(), (int) mc.player.getY(), (int) mc.player.getZ());

        for (int x = -renderDistance; x <= renderDistance; x++) {
            for (int y = -renderDistance; y <= renderDistance; y++) {
                for (int z = -renderDistance; z <= renderDistance; z++) {
                    BlockPos pos = playerPos.add(x, y, z);
                    BlockEntity blockEntity = world.getBlockEntity(pos);

                    if (blockEntity != null) {
                        blockEntities.add(blockEntity);
                    }
                }
            }
        }

        return blockEntities;
    }
}