package net.The2019.NewBase.features.hudDisplays;

import net.minecraft.client.MinecraftClient;

public class FpsDisplay {

    private static final MinecraftClient mc = MinecraftClient.getInstance();
    public static String fps = "";

    public static void setFps() {
        fps = String.valueOf(mc.getCurrentFps());
    }
}
