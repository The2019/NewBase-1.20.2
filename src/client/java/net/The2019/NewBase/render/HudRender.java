package net.The2019.NewBase.render;

import net.The2019.NewBase.features.hudDisplays.BiomeDisplay;
import net.The2019.NewBase.features.hudDisplays.CoordinatesDisplay;
import net.The2019.NewBase.features.hudDisplays.FpsDisplay;
import net.The2019.NewBase.utils.DisplayElements;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HudRender {
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    private static final List<DisplayElements> displayElements = new ArrayList<>();

    public static void registerHudRendering() {
        displayElements.add(new DisplayElements("Coordinates", Color.GREEN.getRGB(), CoordinatesDisplay::getPositionText));
        displayElements.add(new DisplayElements("Biome", Color.GREEN.getRGB(), BiomeDisplay::getBiomeText));
        displayElements.add(new DisplayElements("Fps", Color.GREEN.getRGB(), FpsDisplay::getFpsText));

        //displayElements.get(0).setActive(false);

        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
            int yOffset = 10;

            for (DisplayElements element : displayElements) {
                if (element.isActive()) {
                    drawContext.drawText(mc.textRenderer, element.getText(), 10, yOffset, element.getColor(), false);
                    yOffset += 10; // Adjust the Y position for the next element
                }
            }
        });
    }
}