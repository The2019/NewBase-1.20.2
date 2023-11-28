package net.The2019.NewBase.utils;

import net.The2019.NewBase.screens.ChatCoordinatesScreen;
import net.The2019.NewBase.screens.ConfigScreen;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.lwjgl.glfw.GLFW;

import static net.The2019.NewBase.config.ModuleConfig.readModule;
import static net.The2019.NewBase.config.ModuleConfig.saveModuleState;
import static net.The2019.NewBase.config.ModuleStates.placer;

public class InitKeyBindings {

    private static final MinecraftClient mc = MinecraftClient.getInstance();


    public static void initKeys(){
        KeyBinding configScreen = KeyBindingHelper.registerKeyBinding(new KeyBinding("newbase.keybinds.configscreen", GLFW.GLFW_KEY_O, "newbase.name"));

        KeyBinding chatCoordinates = KeyBindingHelper.registerKeyBinding(new KeyBinding("newbase.keybinds.sendcoordinates", GLFW.GLFW_KEY_P, "newbase.name"));

        KeyBinding toggleFps = KeyBindingHelper.registerKeyBinding(new KeyBinding("newbase.keybinds.togglefps", GLFW.GLFW_KEY_K, "newbase.name"));


        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(configScreen.wasPressed()){
                mc.setScreen(new ConfigScreen(mc.currentScreen, mc.options));
            }
            if(chatCoordinates.wasPressed()){
                mc.setScreen(new ChatCoordinatesScreen(mc.currentScreen, mc.options));
            }
            if(toggleFps.wasPressed()){
                MinecraftClient.getInstance().options.forwardKey.setPressed(!readModule(placer));
                saveModuleState(placer, !readModule(placer));
            }
        });
    }
}
