package net.The2019.NewBase.features.hudDisplays;

import net.minecraft.client.MinecraftClient;

public class FpsDisplay {
    private static final MinecraftClient mc = MinecraftClient.getInstance();

    public static String fps = "";

    public static void extractFPS() {
        String fpsDebugString = mc.fpsDebugString.toString();
        String[] parts = fpsDebugString.split(" ");
        for (String part : parts) {
            if (part.matches("\\d+")) {
                fps = part;
            }
        }
    }
}
