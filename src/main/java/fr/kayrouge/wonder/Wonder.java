package fr.kayrouge.wonder;

import fr.kayrouge.wonder.items.component.WonderItemComponents;
import fr.kayrouge.wonder.items.runes.Runes;
import fr.kayrouge.wonder.menu.WonderMenuTypes;
import fr.kayrouge.wonder.items.WonderItemGroups;
import fr.kayrouge.wonder.items.WonderItems;
import fr.kayrouge.wonder.network.WonderPackets;
import fr.kayrouge.wonder.utils.configs.WonderConfig;
import io.wispforest.owo.network.OwoNetChannel;
import io.wispforest.owo.registration.reflect.FieldRegistrationHandler;
import net.fabricmc.api.ModInitializer;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Wonder implements ModInitializer {
	public static final String MOD_ID = "wonder";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final WonderConfig CONFIG = WonderConfig.createAndLoad();

	public static final OwoNetChannel CHANNEL = OwoNetChannel.create(id("main"));


	@Override  
	public void onInitialize() {
		WonderRegistries.init();

		FieldRegistrationHandler.register(Runes.class, MOD_ID, false);
		FieldRegistrationHandler.register(WonderItemComponents.class, MOD_ID, false);
		FieldRegistrationHandler.register(WonderItems.class, MOD_ID, false);
		FieldRegistrationHandler.register(WonderMenuTypes.class, MOD_ID, false);

		WonderItemGroups.ITEMS.initialize();
		WonderItemGroups.RUNES.initialize();

		WonderPackets.register();
	}


	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}