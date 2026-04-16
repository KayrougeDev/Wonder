package fr.kayrouge.wonder.items.runes;

import fr.kayrouge.wonder.WonderRegistries;
import io.wispforest.owo.registration.reflect.AutoRegistryContainer;
import net.minecraft.core.Registry;

import java.awt.*;

public class Runes implements AutoRegistryContainer<Rune> {

    public static final Rune SPEED = new Rune(Color.RED.getRGB());
    public static final Rune REGEN = new Rune(Color.GREEN.getRGB());

    @Override
    public Registry<Rune> getRegistry() {
        return WonderRegistries.RUNES;
    }

    @Override
    public Class<Rune> getTargetFieldType() {
        return Rune.class;
    }
}
