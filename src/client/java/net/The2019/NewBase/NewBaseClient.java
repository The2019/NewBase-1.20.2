package net.The2019.NewBase;

import net.The2019.NewBase.config.ModuleConfig;
import net.The2019.NewBase.module.ChunkRender;
import net.The2019.NewBase.module.render.BeeHiveHelper;
import net.The2019.NewBase.render.HudRender;
import net.The2019.NewBase.utils.InitKeyBindings;
import net.The2019.NewBase.utils.PermissionLevel;
import net.fabricmc.api.ClientModInitializer;

public class NewBaseClient implements ClientModInitializer {

	public static final String MOD_ID = "newbase";

	@Override
	public void onInitializeClient() {
		PermissionLevel.initAllowedPlayers();
		HudRender.registerHudRendering();

		BeeHiveHelper.register();
		ChunkRender.renderChunkOutline();

		InitKeyBindings.initKeys();

		ModuleConfig.init();
	}
}
