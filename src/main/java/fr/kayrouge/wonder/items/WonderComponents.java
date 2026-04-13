package fr.kayrouge.wonder.items;

import io.wispforest.owo.registration.reflect.AutoRegistryContainer;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;

public class WonderComponents implements AutoRegistryContainer<DataComponentType<?>> {


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
