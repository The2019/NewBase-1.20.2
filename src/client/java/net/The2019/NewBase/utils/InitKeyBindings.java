package net.The2019.NewBase.utils;

import net.The2019.NewBase.features.ChatCoordinates;
import net.The2019.NewBase.screen.ConfigScreen;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

public class InitKeyBindings {

    private static final MinecraftClient mc = MinecraftClient.getInstance();

    public static void initKeys(){
        KeyBinding chatCoordinates = KeyBindingHelper.registerKeyBinding(new KeyBinding("Send Coordinates", GLFW.GLFW_KEY_P, "New Base"));

        KeyBinding configScreen = KeyBindingHelper.registerKeyBinding(new KeyBinding("Opens Config Screen", GLFW.GLFW_KEY_O, "New Base"));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(chatCoordinates.wasPressed()){
                ChatCoordinates.sendCoordinates();
            }
            if(configScreen.wasPressed()){
                mc.setScreen(new ConfigScreen(mc.currentScreen, mc.options, "Config Screen"));
            }
        });
    }
}
