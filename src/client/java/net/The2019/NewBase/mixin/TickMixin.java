package net.The2019.NewBase.mixin;

import net.The2019.NewBase.features.AutoCrystal;
import net.The2019.NewBase.features.Placer;
import net.The2019.NewBase.features.hudDisplays.BiomDisplay;
import net.The2019.NewBase.features.hudDisplays.CoordinatesDisplay;
import net.The2019.NewBase.features.hudDisplays.FpsDisplay;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class TickMixin {

    @Inject(at = @At("HEAD"), method = "tick")
    private void onTick(CallbackInfo ci){
        AutoCrystal.autoCrystal();
        BiomDisplay.biomDisplay();
        CoordinatesDisplay.coordinates();
        FpsDisplay.extractFPS();
        Placer.place();
    }
}
