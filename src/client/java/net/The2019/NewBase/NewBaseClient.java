package net.The2019.NewBase;

import net.The2019.NewBase.features.autoCrystal;
import net.The2019.NewBase.features.biomDisplay;
import net.The2019.NewBase.features.coordinatesDisplay;
import net.The2019.NewBase.features.placer;
import net.The2019.NewBase.render.HudRender;
import net.fabricmc.api.ClientModInitializer;

public class NewBaseClient implements ClientModInitializer {

	public static final String MOD_ID = "newbase";

	@Override
	public void onInitializeClient() {
		HudRender.hudRendering();
		placer.place();
		biomDisplay.biomDisplay();
		coordinatesDisplay.coordinates();
		autoCrystal.autoCrystal();
	}
}
