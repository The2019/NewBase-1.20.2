package net.The2019.NewBase.features.hudDisplays;

import net.minecraft.client.MinecraftClient;

public class BiomDisplay {

    private static final MinecraftClient mc = MinecraftClient.getInstance();
    public static String biom = "";

    public static void biomDisplay(){
        if(mc.player != null) {
            biom = mc.player.networkHandler.getWorld().getBiome(mc.player.getBlockPos()).toString();
        }
    }
}
