package net.The2019.NewBase.utils;

import net.minecraft.client.MinecraftClient;
import net.minecraft.network.packet.Packet;

public class SendPacket {

    private static final MinecraftClient mc = MinecraftClient.getInstance();

    public static void sendPackets(Packet packet){
        mc.player.networkHandler.sendPacket(packet);
    }

}
