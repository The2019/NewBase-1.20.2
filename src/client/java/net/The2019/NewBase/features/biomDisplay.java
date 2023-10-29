package net.The2019.NewBase.features;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class biomDisplay {

    private static final MinecraftClient mc = MinecraftClient.getInstance();
    public static String biom = "";

    public static void biom(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(mc.player != null){
                biom = mc.player.networkHandler.getWorld().getBiome(mc.player.getBlockPos()).toString();
            }
        });
    }
}
