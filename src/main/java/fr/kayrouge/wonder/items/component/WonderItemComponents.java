package fr.kayrouge.wonder.items.component;

import fr.kayrouge.wonder.items.runes.RuneData;
import io.wispforest.owo.registration.reflect.AutoRegistryContainer;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;

public class WonderItemComponents implements AutoRegistryContainer<DataComponentType<?>> {

    public static final DataComponentType<RuneData> RUNE = DataComponentType.<RuneData>builder().persistent(RuneData.CODEC).build();

    protected static void initialize() {
    }

    @Override
    public Registry<DataComponentType<?>> getRegistry() {
        return BuiltInRegistries.DATA_COMPONENT_TYPE;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class<DataComponentType<?>> getTargetFieldType() {
        return (Class<DataComponentType<?>>) (Object) DataComponentType.class;
    }
}
