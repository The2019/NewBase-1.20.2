package net.The2019.NewBase.features;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import org.lwjgl.glfw.GLFW;

import static net.The2019.NewBase.utils.PermsionLevel.isPlayerAllowed;
import static net.The2019.NewBase.utils.SendPacket.sendPackets;

public class Placer {
    private static final MinecraftClient mc = MinecraftClient.getInstance();

    public static void place(){
        if(isPlayerAllowed){
            KeyBinding placer = KeyBindingHelper.registerKeyBinding(new KeyBinding("Place", GLFW.GLFW_KEY_B, "New Base"));

            ClientTickEvents.END_CLIENT_TICK.register(client -> {
                if(placer.wasPressed()) {
                    BlockHitResult blockHitResult = ((BlockHitResult) mc.crosshairTarget);
                    mc.player.swingHand(mc.player.getActiveHand());
                    sendPackets(new PlayerInteractBlockC2SPacket(Hand.MAIN_HAND, blockHitResult, 1));
                }
            });
        }
    }
}
