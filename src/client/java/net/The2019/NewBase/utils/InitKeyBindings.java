package net.The2019.NewBase.utils;

import net.The2019.NewBase.features.ChatCoordinates;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

public class InitKeyBindings {

    public static void initKeys(){
        KeyBinding chatCoordinates = KeyBindingHelper.registerKeyBinding(new KeyBinding("Send Coordinates", GLFW.GLFW_KEY_P, "New Base"));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(chatCoordinates.wasPressed()){
                ChatCoordinates.sendCoordinates();
            }
        });
    }
}
