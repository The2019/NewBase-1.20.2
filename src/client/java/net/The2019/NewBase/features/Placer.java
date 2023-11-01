package net.The2019.NewBase.features;

import net.minecraft.client.MinecraftClient;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;

import static net.The2019.NewBase.utils.PermissionLevel.isPlayerAllowed;
import static net.The2019.NewBase.utils.SendPacket.sendPackets;

public class Placer {
    private static final MinecraftClient mc = MinecraftClient.getInstance();

    public static void place(){
        if(isPlayerAllowed){
            BlockHitResult blockHitResult = ((BlockHitResult) mc.crosshairTarget);
            mc.player.swingHand(mc.player.getActiveHand());
            sendPackets(new PlayerInteractBlockC2SPacket(Hand.MAIN_HAND, blockHitResult, 1));
        }
    }
}
