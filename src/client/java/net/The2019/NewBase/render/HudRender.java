package net.The2019.NewBase.render;

import net.The2019.NewBase.features.hud.BiomeDisplay;
import net.The2019.NewBase.features.hud.CoordinatesDisplay;
import net.The2019.NewBase.features.hud.FpsDisplay;
import net.The2019.NewBase.utils.DisplayElements;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static net.The2019.NewBase.config.ModuleConfig.readModule;
import static net.The2019.NewBase.config.ModuleStates.*;

public class HudRender {
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    private static final List<DisplayElements> displayElements = new ArrayList<>();

    public static void registerHudRendering() {
        displayElements.add(new DisplayElements("Coordinates", Color.GREEN.getRGB(), CoordinatesDisplay::getPositionText));
        displayElements.add(new DisplayElements("Biome", Color.GREEN.getRGB(), BiomeDisplay::getBiomeText));
        displayElements.add(new DisplayElements("Fps", Color.GREEN.getRGB(), FpsDisplay::getFpsText));

        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
            int yOffset = 10;

            displayElements.get(0).setActive(readModule(coordinateDisplay));
            displayElements.get(1).setActive(readModule(biomeDisplay));
            displayElements.get(2).setActive(readModule(fpsDisplay));

            for (DisplayElements element : displayElements) {
                if (element.isActive()) {
                    drawContext.drawText(mc.textRenderer, element.getText(), 10, yOffset, element.getColor(), false);
                    yOffset += 10; // Adjust the Y position for the next element
                }
            }
        });
    }
}