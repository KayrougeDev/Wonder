package fr.kayrouge.wonder.datagen.providers;

import fr.kayrouge.wonder.Wonder;
import fr.kayrouge.wonder.items.WonderItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import java.util.concurrent.CompletableFuture;

public class WonderItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {

    public static final TagKey<Item> RUNES = TagKey.create(Registries.ITEM, Wonder.id("magic"));

    public WonderItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        valueLookupBuilder(RUNES).add(WonderItems.CRYSTALLIZED_MAGIC, WonderItems.WAND, WonderItems.RUNE);
    }
}
