package net.The2019.NewBase.features;

import net.The2019.NewBase.screen.ChatCoordinatesScreen;
import net.minecraft.client.MinecraftClient;

public class ChatCoordinates {
    private static final MinecraftClient mc = MinecraftClient.getInstance();

    public static void sendCoordinates(){
        mc.setScreen(new ChatCoordinatesScreen(mc.currentScreen, mc.options));
    }
}
