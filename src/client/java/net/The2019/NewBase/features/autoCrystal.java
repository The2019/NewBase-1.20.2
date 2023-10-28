package net.The2019.NewBase.features;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.EndCrystalEntity;

public class autoCrystal {

    private static final MinecraftClient mc = MinecraftClient.getInstance();

    public static void autoCrystal(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (mc.world != null) {
                for(Entity entity : mc.world.getEntities()){
                    if(entity instanceof EndCrystalEntity){
                        if (mc.interactionManager != null) {
                            mc.interactionManager.attackEntity(mc.player, entity);
                        }
                    }
                }
            }
        });
    }
}
