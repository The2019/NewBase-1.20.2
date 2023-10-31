package net.The2019.NewBase.utils;

import net.minecraft.client.MinecraftClient;

import java.util.ArrayList;

public class PermsionLevel {
    private static final ArrayList<String> allowedPlayers = new ArrayList<>();
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    public static Boolean isPlayerAllowed = false;

    public static void init(){
        addPlayers("The2019");
        addPlayers("TheChrisgamer18");
    }

    public static void isPlayerAllowed(){
        if (mc.player != null) {
            String playername = mc.player.getName().toString();
            if(allowedPlayers.contains(playername)){
                isPlayerAllowed = true;
            }
        }
    }

    private static void addPlayers(String players){
        allowedPlayers.add(players);
    }
}
