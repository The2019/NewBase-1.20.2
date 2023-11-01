package net.The2019.NewBase;

import net.The2019.NewBase.render.HudRender;
import net.The2019.NewBase.utils.PermissionLevel;
import net.fabricmc.api.ClientModInitializer;

public class NewBaseClient implements ClientModInitializer {

	public static final NewBaseClient INSTANCE = new NewBaseClient();
	public static final String MOD_ID = "newbase";

	@Override
	public void onInitializeClient() {
		PermissionLevel.initAllowedPlayers();
		HudRender.hudRendering();
	}
	}
