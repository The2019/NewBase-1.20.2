package net.The2019.NewBase.screen;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextWidget;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.text.Text;

import java.util.ArrayList;

public class ConfigScreen extends Screen {
    private final Screen parent;
    private final GameOptions settings;
    private final String name;
    private static ArrayList<Drawable> drawables = new ArrayList<>();
    private static final MinecraftClient mc = MinecraftClient.getInstance();

    public ConfigScreen(Screen parent, GameOptions gameOptions, String name){
        super(Text.of("Config Screen"));
        this.parent = parent;
        this.settings = gameOptions;
        this.name = name;
    }

    public static void addDrawables(){
        drawables.add(new TextWidget(20, 20, 80, 10, Text.of("1"),mc.textRenderer));
        drawables.add(new TextWidget(20, 30, 80, 10, Text.of("2"),mc.textRenderer));
    }

    @Override
    protected void init() {
        this.addDrawable(new TextWidget(20, 10, 80, 10, Text.of(this.name), textRenderer));

        for(Drawable drawable : drawables){
            this.addDrawable(drawable);
        }
    }
}
