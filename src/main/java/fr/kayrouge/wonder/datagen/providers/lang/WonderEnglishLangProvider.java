package fr.kayrouge.wonder.datagen.providers.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class WonderEnglishLangProvider extends FabricLanguageProvider {


    public WonderEnglishLangProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(packOutput, registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.@NonNull Provider registryLookup, @NonNull TranslationBuilder translationBuilder) {
        translationBuilder.add("text.config.wonder-config.option.aBooleanToggle", "Yes or no ?");
        translationBuilder.add("text.config.wonder-config.option.aBooleanToggle.tooltip", "To be or not to be ?\nIdk");
    }
}
