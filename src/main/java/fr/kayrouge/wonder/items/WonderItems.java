package fr.kayrouge.wonder.items;

import fr.kayrouge.wonder.Wonder;
import io.wispforest.owo.registration.reflect.AutoRegistryContainer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class WonderItems implements AutoRegistryContainer<Item> {

    public static final Item CRYSTALLIZED_MAGIC = new Item(new Item.Properties().group(WonderItemGroups.ITEMS).setId(id("crystallized_magic")));

    public static final Item WAND = new WandItem(new Item.Properties().setId(id("wand")));

    public static final Item RUNE = new RuneItem(new Item.Properties().setId(id("rune")));

    @Override
    public Registry<Item> getRegistry() {
        return BuiltInRegistries.ITEM;
    }

    @Override
    public Class<Item> getTargetFieldType() {
        return Item.class;
    }

    private static ResourceKey<Item> id(final String name) {
        return ResourceKey.create(Registries.ITEM, Wonder.id(name));
    }
}
