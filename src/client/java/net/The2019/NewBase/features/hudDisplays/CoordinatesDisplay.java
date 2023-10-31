package net.The2019.NewBase.features.hudDisplays;

import net.minecraft.client.MinecraftClient;

public class CoordinatesDisplay {

    private static final MinecraftClient mc = MinecraftClient.getInstance();

    public static String x = "";
    public static String y = "";
    public static String z = "";

    public static void coordinates(){
        if(mc.player != null){
            x = String.valueOf(mc.player.getBlockPos().getX());
            y = String.valueOf(mc.player.getBlockPos().getY());
            z = String.valueOf(mc.player.getBlockPos().getZ());
        }
    }
}