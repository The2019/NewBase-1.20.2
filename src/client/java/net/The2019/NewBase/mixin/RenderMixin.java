package net.The2019.NewBase.mixin;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class RenderMixin {

    @Inject(method = "render", at = @At("RETURN"))
    public void renderHud(DrawContext context, float tickDelta, CallbackInfo ci){
    }
}
