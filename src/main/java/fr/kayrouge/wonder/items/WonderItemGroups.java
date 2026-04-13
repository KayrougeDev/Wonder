package fr.kayrouge.wonder.items;

import fr.kayrouge.wonder.Wonder;
import io.wispforest.owo.itemgroup.Icon;
import io.wispforest.owo.itemgroup.OwoItemGroup;
import io.wispforest.owo.itemgroup.gui.ItemGroupButton;

public class WonderItemGroups {

    public static final OwoItemGroup ITEMS = OwoItemGroup
            .builder(Wonder.id("items"), () -> Icon.of(WonderItems.CRYSTALLIZED_MAGIC))
            .initializer(owoItemGroup -> {
                owoItemGroup.addButton(ItemGroupButton.modrinth(owoItemGroup, ""));
                owoItemGroup.addButton(ItemGroupButton.curseforge(owoItemGroup, ""));


            })
            .build();

}
