package net.The2019.NewBase.screens;

import net.The2019.NewBase.screens.configScreen.HudScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class ConfigScreen extends Screen {
    private final Screen parent;
    private final GameOptions settings;
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    private int y = 50;
    private int x = 20;

    public ConfigScreen(Screen parent, GameOptions gameOptions) {
        super(Text.translatable("newbase.configscreen.name"));
        this.parent = parent;
        this.settings = gameOptions;
    }

    @Override
    protected void init() {
        this.addDrawable(new TextWidget(x, 20, 100, 20, Text.translatable("newbase.configscreen.name").formatted(Formatting.BOLD), textRenderer)).alignLeft();

        //Hud
        this.addDrawable(new TextWidget(x, y, 100, 20, Text.translatable("newbase.configscreen.hud"), mc.textRenderer).alignLeft());
        this.addDrawableChild(new ButtonWidget.Builder(Text.translatable("newbase.configscreen.hudbutton"), button -> {mc.setScreen(new HudScreen(mc.currentScreen, mc.options));}).tooltip(Tooltip.of(Text.translatable("newbase.configscreen.hudtooltip"))).dimensions(this.width - 220, y, 200, 20).build());

        //Render
        this.addDrawable(new TextWidget(x, y+30, 100, 20, Text.translatable("newbase.configscreen.render"), mc.textRenderer).alignLeft());
        this.addDrawableChild(new ButtonWidget.Builder(Text.translatable("newbase.configscreen.renderbutton"), button -> {mc.player.sendMessage(Text.literal("test"));}).tooltip(Tooltip.of(Text.translatable("newbase.configscreen.rendertooltip"))).dimensions(this.width - 220, y+30, 200, 20).build());


    }
}