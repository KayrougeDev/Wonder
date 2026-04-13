package fr.kayrouge.wonder.datagen;

import fr.kayrouge.wonder.datagen.providers.lang.WonderEnglishLangProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class WonderDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        // Translation
        pack.addProvider(WonderEnglishLangProvider::new);
    }
}
