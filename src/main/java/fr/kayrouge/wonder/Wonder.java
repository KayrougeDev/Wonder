package fr.kayrouge.wonder;

import fr.kayrouge.wonder.items.WonderComponents;
import fr.kayrouge.wonder.items.WonderItemGroups;
import fr.kayrouge.wonder.items.WonderItems;
import fr.kayrouge.wonder.utils.configs.WonderConfig;
import io.wispforest.owo.registration.reflect.FieldRegistrationHandler;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Wonder implements ModInitializer {
	public static final String MOD_ID = "wonder";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final WonderConfig CONFIG = WonderConfig.createAndLoad();



	@Override  
	public void onInitialize() {
		FieldRegistrationHandler.register(WonderComponents.class, MOD_ID, false);
		FieldRegistrationHandler.register(WonderItems.class, MOD_ID, false);

		WonderItemGroups.ITEMS.initialize();

	}


	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}