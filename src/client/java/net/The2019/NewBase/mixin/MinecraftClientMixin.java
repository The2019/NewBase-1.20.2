package net.The2019.NewBase.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
    @Inject(at = @At("HEAD"), method = "hasOutline")
    private void renderOutline(Entity entity, CallbackInfoReturnable<Boolean> ci){
        if(entity.getType() == EntityType.PLAYER && entity != MinecraftClient.getInstance().player){
            ci.setReturnValue(true);
        }
    }
}
