package net.The2019.NewBase.features.generic;

import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;

import static net.The2019.NewBase.render.WorldRender.renderBlock;

public class ChunkRender {
    private static final MinecraftClient mc = MinecraftClient.getInstance();

    public static void renderChunkOutline(){
        WorldRenderEvents.END.register(context -> {
            renderBlock(context, new Box(new BlockPos(0, 70, 0), new BlockPos(10, 80, 10)));
        });
    }
}
