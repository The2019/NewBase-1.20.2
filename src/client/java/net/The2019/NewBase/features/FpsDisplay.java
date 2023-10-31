package net.The2019.NewBase.features;

import net.minecraft.client.MinecraftClient;

public class FpsDisplay {
    private static final MinecraftClient mc = MinecraftClient.getInstance();

    public static String fps = mc.fpsDebugString.toString();
}
