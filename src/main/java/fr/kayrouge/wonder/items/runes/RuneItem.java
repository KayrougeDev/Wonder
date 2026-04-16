package fr.kayrouge.wonder.items.runes;

import fr.kayrouge.wonder.items.component.WonderItemComponents;
import net.minecraft.world.item.Item;

import java.util.List;

public class RuneItem extends Item {

    public RuneItem(Properties properties) {
        super(properties.component(WonderItemComponents.RUNE, new RuneData(List.of())));
    }
}
