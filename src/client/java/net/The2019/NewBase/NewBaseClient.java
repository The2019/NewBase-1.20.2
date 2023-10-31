package net.The2019.NewBase;

import net.The2019.NewBase.features.BiomDisplay;
import net.The2019.NewBase.features.CoordinatesDisplay;
import net.The2019.NewBase.features.Placer;
import net.The2019.NewBase.render.HudRender;
import net.fabricmc.api.ClientModInitializer;

public class NewBaseClient implements ClientModInitializer {

	public static final String MOD_ID = "newbase";

	@Override
	public void onInitializeClient() {
		HudRender.hudRendering();
		Placer.place();
		BiomDisplay.biomDisplay();
		CoordinatesDisplay.coordinates();
	}
}
