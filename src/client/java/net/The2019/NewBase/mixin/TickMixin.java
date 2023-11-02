package net.The2019.NewBase.mixin;

import net.The2019.NewBase.features.hudDisplays.BiomDisplay;
import net.The2019.NewBase.features.hudDisplays.CoordinatesDisplay;
import net.The2019.NewBase.features.hudDisplays.FpsDisplay;
import net.The2019.NewBase.utils.PermissionLevel;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public abstract class TickMixin {

    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci){
        BiomDisplay.biomDisplay();
        CoordinatesDisplay.coordinates();
        FpsDisplay.setFps();

        PermissionLevel.checkPlayerPermission();
    }
}
