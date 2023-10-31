package net.The2019.NewBase.render;

import net.The2019.NewBase.features.hudDisplays.BiomDisplay;
import net.The2019.NewBase.features.hudDisplays.CoordinatesDisplay;
import net.The2019.NewBase.features.hudDisplays.FpsDisplay;
import net.The2019.NewBase.utils.DisplayElements;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HudRender {
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    private static final List<DisplayElements> displayElements = new ArrayList<>();

    public static void hudRendering() {
        // Add your display elements to the list
        displayElements.add(new DisplayElements("Coordinates", Color.GREEN.getRGB(), () -> "X: " + CoordinatesDisplay.x + " Y: " + CoordinatesDisplay.y + " Z: " + CoordinatesDisplay.z));
        displayElements.add(new DisplayElements("Biom", Color.GREEN.getRGB(), () -> "Biom: " + BiomDisplay.biom));
        displayElements.add(new DisplayElements("Fps", Color.GREEN.getRGB(), () -> "FPS: " + FpsDisplay.fps));

        //displayElements.get(0).setActive(false);

        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
            TextRenderer renderer = mc.textRenderer;
            int yOffset = 10;

            // Render each active display element
            for (DisplayElements element : displayElements) {
                if (element.isActive()) {
                    drawContext.drawText(renderer, element.getText(), 10, yOffset, element.getColor(), false);
                    yOffset += 10; // Adjust the Y position for the next element
                }
            }
        });
    }
}