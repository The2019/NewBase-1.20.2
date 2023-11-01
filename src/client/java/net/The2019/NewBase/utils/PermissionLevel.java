package net.The2019.NewBase.utils;

import net.minecraft.client.MinecraftClient;

import java.util.ArrayList;

public class PermissionLevel {
    private static final ArrayList<String> allowedPlayers = new ArrayList<>();
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    public static boolean isPlayerAllowed = false;

    public static void initAllowedPlayers() {
        addPlayer("The2019");
        addPlayer("TheChrisgamer18");
    }

    public static void checkPlayerPermission() {
        if (mc.player != null) {
            String playerName = mc.player.getName().getString();
            isPlayerAllowed = allowedPlayers.contains(playerName);
        }
    }

    private static void addPlayer(String playerName) {
        allowedPlayers.add(playerName);
    }
}