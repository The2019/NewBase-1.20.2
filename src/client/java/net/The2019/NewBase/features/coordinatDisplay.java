package net.The2019.NewBase.features;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class coordinatDisplay {

    private static final MinecraftClient mc = MinecraftClient.getInstance();

    public static String x = "";
    public static String y = "";
    public static String z = "";

    public static void coordinats(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(mc.player != null){
                x = String.valueOf(mc.gameRenderer.getCamera().getBlockPos().getX());
                y = String.valueOf(mc.gameRenderer.getCamera().getBlockPos().getY());
                z = String.valueOf(mc.gameRenderer.getCamera().getBlockPos().getZ());
            }
        });
    }
}