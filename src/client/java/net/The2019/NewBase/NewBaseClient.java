package net.The2019.NewBase;

import net.The2019.NewBase.features.Placer;
import net.The2019.NewBase.render.HudRender;
import net.The2019.NewBase.utils.PermissionLevel;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

public class NewBaseClient implements ClientModInitializer {

	public static final String MOD_ID = "newbase";

	@Override
	public void onInitializeClient() {

		KeyBinding placer = KeyBindingHelper.registerKeyBinding(new KeyBinding("Place", GLFW.GLFW_KEY_B, "New Base"));

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if (placer.wasPressed()) {
				Placer.place();
			}
		});



		PermissionLevel.initAllowedPlayers();
		HudRender.hudRendering();
	}
}
