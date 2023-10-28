package net.The2019.NewBase.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.PlayerListHud;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerListHud.class)
public class PlayerListMixin {

    @Unique
    private static final String playername = "§c" + MinecraftClient.getInstance().getSession().getUsername();

    @Inject(method = "getPlayerName",at = @At("RETURN"), cancellable = true)
    public void getPlayerName(PlayerListEntry entry, CallbackInfoReturnable<Text> cir){
        if(entry.getProfile().getName().equals(MinecraftClient.getInstance().getSession().getUsername())){
            if(MinecraftClient.getInstance().getSession().getUsername().equals("The2019")){
                cir.setReturnValue(Text.literal(playername + " §a[NB]"));
            }else {
                cir.setReturnValue(Text.literal(MinecraftClient.getInstance().getSession().getUsername() + " §a[NB]"));
            }
        }
    }
}
