package fr.kayrouge.wonder;

import fr.kayrouge.wonder.items.runes.Rune;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.core.MappedRegistry;
import net.minecraft.resources.ResourceKey;

public class WonderRegistries {

    public static final MappedRegistry<Rune> RUNES = create("runes", Rune.class);

    private static <T> MappedRegistry<T> create(String id, Class<T> clazz) {
        return FabricRegistryBuilder.create(
                ResourceKey.<T>createRegistryKey(Wonder.id(id))
        ).buildAndRegister();
    }

    protected static void init() {}
}
