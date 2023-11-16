package net.The2019.NewBase.screen;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

import static net.The2019.NewBase.features.config.ModuleStates.*;

public class ConfigScreen extends Screen {
    private final Screen parent;
    private final GameOptions settings;
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    private static List<ButtonWidget> buttonWidgetList = new ArrayList<>();
    private int y = 30;

    public ConfigScreen(Screen parent, GameOptions gameOptions) {
        super(Text.translatable("newbase.configscreen.name"));
        this.parent = parent;
        this.settings = gameOptions;
    }

    @Override
    protected void init() {
        buttonWidgetList.add((new ButtonWidget.Builder(Text.translatable("newbase.configscreen.togglecoordinates"), button -> {
            coordinatesDisplayState = !coordinatesDisplayState;
        }).dimensions(20, y, 150, 20).build()));

        buttonWidgetList.add((new ButtonWidget.Builder(Text.translatable("newbase.configscreen.togglebiom"), button -> {
            biomDisplayState = !biomDisplayState;
        }).dimensions(20, y * 2, 150, 20).build()));

        buttonWidgetList.add((new ButtonWidget.Builder(Text.translatable("newbase.configscreen.togglefps"), button -> {
            fpsDisplayState = !fpsDisplayState;
        }).dimensions(20, y * 3, 150, 20).build()));

        this.addDrawable(new TextWidget(20, 10, 80, 10, Text.translatable("newbase.configscreen.name"), textRenderer));
    }

    @Override
    public void tick() {
        for (ButtonWidget buttonWidget : buttonWidgetList) {
            boolean buttonState = false;

            // Check which button is being processed
            if (buttonWidget.getMessage().getString().equals("newbase.configscreen.togglecoordinates")) {
                buttonState = coordinatesDisplayState;
            } else if (buttonWidget.getMessage().getString().equals("newbase.configscreen.togglebiom")) {
                buttonState = biomDisplayState;
            } else if (buttonWidget.getMessage().getString().equals("newbase.configscreen.togglefps")) {
                buttonState = fpsDisplayState;
            }

            buttonWidget.setTooltip(Tooltip.of(Text.of(isEnabled(buttonState))));
            this.addDrawableChild(buttonWidget);
        }
    }
}