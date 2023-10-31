package net.The2019.NewBase.render;

import net.The2019.NewBase.features.CoordinatesDisplay;
import net.The2019.NewBase.features.BiomDisplay;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;

import java.awt.*;

public class HudRender {
    private static final MinecraftClient mc = MinecraftClient.getInstance();

    public static void hudRendering(){
     HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
         TextRenderer renderer = mc.textRenderer;
         drawContext.drawText(renderer,"X: " + CoordinatesDisplay.x + " " + "Y: " + CoordinatesDisplay.y + " " + "Z: " + CoordinatesDisplay.z, 10, 10, Color.GREEN.getRGB(), false);
         drawContext.drawText(renderer, "Biom: " + BiomDisplay.biom, 10, 20, Color.GREEN.getRGB(), false);
     });
    }
}
