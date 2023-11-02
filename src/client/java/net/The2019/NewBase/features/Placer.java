package net.The2019.NewBase.features;

import net.The2019.NewBase.utils.PermissionLevel;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;
import net.minecraft.util.hit.BlockHitResult;

import static net.The2019.NewBase.utils.SendPacket.sendPacket;

public class Placer {
    private static final MinecraftClient mc = MinecraftClient.getInstance();

    public static void place() {
        if (PermissionLevel.isPlayerAllowed() && mc.crosshairTarget instanceof BlockHitResult blockHitResult) {
            mc.player.swingHand(mc.player.getActiveHand());
            sendPacket(new PlayerInteractBlockC2SPacket(mc.player.getActiveHand(), blockHitResult, 1));
        }
    }
}
