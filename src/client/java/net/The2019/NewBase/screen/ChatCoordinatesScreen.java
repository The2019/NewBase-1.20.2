package net.The2019.NewBase.screen;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;

public class ChatCoordinatesScreen extends Screen {
    private final Screen parent;
    private final GameOptions settings;
    private static final MinecraftClient mc = MinecraftClient.getInstance();

    public ChatCoordinatesScreen(Screen parent, GameOptions options) {
        super(Text.of("Chat Coordinates Screen"));
        this.parent = parent;
        this.settings = options;
    }

    @Override
    protected void init() {
        ButtonWidget yesButton = new ButtonWidget.Builder(Text.literal("§aYes"), button -> {
            if (mc.player != null) {
                BlockPos playerPos = mc.player.getBlockPos();
                mc.player.networkHandler.sendChatMessage(String.format("X: %s Y: %s Z: %s", playerPos.getX(), playerPos.getY(), playerPos.getZ()));
                mc.setScreen(null);
            }
        }).dimensions(this.width / 2 - 90, this.height / 2, 80, 20).build();

        ButtonWidget noButton = new ButtonWidget.Builder(Text.literal("§4No"), button -> {
            mc.setScreen(null);
        }).dimensions(this.width / 2, this.height / 2, 80, 20).build();

        this.addDrawable(new TextWidget(this.width / 2 - 250, this.height / 2 - 30, 500, 20, Text.of("Press §aYes §fto send Coordinates in the chat or §4No §fto return back to the game."), textRenderer));
        this.addDrawableChild(yesButton);
        this.addDrawableChild(noButton);
    }
}

