package net.The2019.NewBase.screen;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.text.Text;

public class ConfigScreen extends Screen {
    private final Screen parent;
    private final GameOptions settings;
    private final String name;

    public ConfigScreen(Screen parent, GameOptions gameOptions, String name){
        super(Text.of("Config Screen"));
        this.parent = parent;
        this.settings = gameOptions;
        this.name = name;
    }

    @Override
    protected void init() {
        this.addDrawable(new TextWidget(20, 10, 80, 10, Text.of(this.name), textRenderer));
    }

    @Override
    public void renderInGameBackground(DrawContext context) {
    }
}
