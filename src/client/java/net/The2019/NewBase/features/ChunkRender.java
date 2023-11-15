package net.The2019.NewBase.features;

import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.minecraft.client.MinecraftClient;

public class ChunkRender {
    private static final MinecraftClient mc = MinecraftClient.getInstance();

    public static void renderChunkOutline(){
        WorldRenderEvents.END.register(context -> {
        });
    }
}
