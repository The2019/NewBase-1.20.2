package net.The2019.NewBase.features;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class coordinatesDisplay {

    private static final MinecraftClient mc = MinecraftClient.getInstance();

    public static String x = "";
    public static String y = "";
    public static String z = "";

    public static void coordinates(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(mc.player != null){
                x = String.valueOf(mc.player.getBlockPos().getX());
                y = String.valueOf(mc.player.getBlockPos().getY());
                z = String.valueOf(mc.player.getBlockPos().getZ());
            }
        });
    }
}