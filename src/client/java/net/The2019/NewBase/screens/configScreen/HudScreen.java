package net.The2019.NewBase.screens.configScreen;

import net.The2019.NewBase.screens.ConfigScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.text.Text;

import static net.The2019.NewBase.features.config.ModuleStates.*;

public class HudScreen extends Screen {
    private final Screen parent;
    private final GameOptions settings;
    private static int x = 20;
    private static int y = 50;
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    private static Text coordinatesToggle = Text.translatable("newbase.hudscreen.enabled");
    private static Text biomeToggle = Text.translatable("newbase.hudscreen.enabled");
    private static Text fpsToggle = Text.translatable("newbase.hudscreen.enabled");

    public HudScreen(Screen parent, GameOptions settings) {
        super(Text.translatable("newbase.hudscreen.name"));
        this.parent = parent;
        this.settings = settings;
    }

    @Override
    protected void init() {

        this.addDrawableChild(new ButtonWidget.Builder(Text.translatable("newbase.hudscreen.back"), button -> {mc.setScreen(new ConfigScreen(mc.currentScreen, mc.options));}).dimensions(17, 20, 100,20).build());

        //Coordinates
        this.addDrawable(new TextWidget(x, y, 500, 20, Text.translatable("newbase.hudscreen.togglecoordinatesdisplay"), mc.textRenderer).alignLeft());
        this.addDrawableChild(new ButtonWidget.Builder(coordinatesToggle, button -> {
            coordinatesToggle = toggleModule(coordinatesToggle);
            mc.setScreen(new HudScreen(mc.currentScreen, mc.options));
            coordinatesDisplayState = !coordinatesDisplayState;

        }).tooltip(Tooltip.of(Text.translatable("newbase.hudscreen.tooltip"))).dimensions(this.width - 220, y, 200, 20).build());

        //Biome
        this.addDrawable(new TextWidget(x, y+30, 500, 20, Text.translatable("newbase.hudscreen.togglebiomedisplay"), mc.textRenderer).alignLeft());
        this.addDrawableChild(new ButtonWidget.Builder(biomeToggle, button -> {
            biomeToggle = toggleModule(biomeToggle);
            mc.setScreen(new HudScreen(mc.currentScreen, mc.options));
            biomDisplayState = !biomDisplayState;

        }).tooltip(Tooltip.of(Text.translatable("newbase.hudscreen.tooltip"))).dimensions(this.width - 220, y+30, 200, 20).build());

        //Fps
        this.addDrawable(new TextWidget(x, y+60, 500, 20, Text.translatable("newbase.hudscreen.togglefpsdisplay"), mc.textRenderer).alignLeft());
        this.addDrawableChild(new ButtonWidget.Builder(fpsToggle, button -> {
            fpsToggle = toggleModule(fpsToggle);
            mc.setScreen(new HudScreen(mc.currentScreen, mc.options));
            fpsDisplayState = !fpsDisplayState;

        }).tooltip(Tooltip.of(Text.translatable("newbase.hudscreen.tooltip"))).dimensions(this.width - 220, y+60, 200, 20).build());
    }

    private static Text toggleModule(Text toggle){
        if(toggle.equals(Text.translatable("newbase.hudscreen.enabled"))){
            toggle = Text.translatable("newbase.hudscreen.disabled");
        }else {
            toggle = Text.translatable("newbase.hudscreen.enabled");
        }
        return toggle;
    }
}
