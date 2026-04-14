package fr.kayrouge.wonder.client.screen.container;

import io.wispforest.owo.registration.reflect.AutoRegistryContainer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.MenuType;

public class WonderMenuTypes implements AutoRegistryContainer<MenuType<?>> {


    public static final MenuType<TestContainerMenu> TEST = new MenuType<>(TestContainerMenu::new, FeatureFlagSet.of());


    @Override
    public Registry<MenuType<?>> getRegistry() {
        return BuiltInRegistries.MENU;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class<MenuType<?>> getTargetFieldType() {
        return (Class<MenuType<?>>) (Object) MenuType.class;
    }
}
