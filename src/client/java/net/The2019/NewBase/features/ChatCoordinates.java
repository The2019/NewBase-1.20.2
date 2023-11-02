package net.The2019.NewBase.features;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;

public class ChatCoordinates {
    private static final MinecraftClient mc = MinecraftClient.getInstance();

    public static void sendCoordinates(){
        if (mc.player != null) {
            BlockPos playerPos = mc.player.getBlockPos();
            mc.player.networkHandler.sendChatMessage(String.format("X: %s Y: %s Z: %s", playerPos.getX(), playerPos.getY(), playerPos.getZ()));
        }
    }
}
