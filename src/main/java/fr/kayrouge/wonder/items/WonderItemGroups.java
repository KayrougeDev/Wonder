package fr.kayrouge.wonder.items;

import fr.kayrouge.wonder.Wonder;
import fr.kayrouge.wonder.WonderRegistries;
import fr.kayrouge.wonder.items.component.WonderItemComponents;
import fr.kayrouge.wonder.items.runes.Rune;
import fr.kayrouge.wonder.items.runes.RuneData;
import io.wispforest.owo.itemgroup.Icon;
import io.wispforest.owo.itemgroup.OwoItemGroup;
import io.wispforest.owo.itemgroup.gui.ItemGroupButton;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.List;

public class WonderItemGroups {

    public static final OwoItemGroup ITEMS = OwoItemGroup
            .builder(Wonder.id("items"), () -> Icon.of(WonderItems.CRYSTALLIZED_MAGIC))
            .initializer(owoItemGroup -> {
                owoItemGroup.addButton(ItemGroupButton.modrinth(owoItemGroup, ""));
                owoItemGroup.addButton(ItemGroupButton.curseforge(owoItemGroup, ""));
            })
            .build();

    public static final OwoItemGroup RUNES = OwoItemGroup
            .builder(Wonder.id("runes"), () -> Icon.of(Wonder.id("textures/item/rune"), 0, 0, 16, 16))
            .initializer(owoItemGroup -> {
                owoItemGroup.addCustomTab(Icon.of(Items.EMERALD), "runes", (context, entries) -> {
                    WonderRegistries.RUNES.iterator().forEachRemaining(rune -> {
                        entries.accept(runeItem(rune, 0));
                        entries.accept(runeItem(rune, 1));
                        entries.accept(runeItem(rune, 2));
                    });
                }, true);

            })
            .build();

    private static ItemStack runeItem(Rune rune, int level) {
        ItemStack stack = new ItemStack(WonderItems.RUNE);
        stack.set(WonderItemComponents.RUNE, new RuneData(List.of(
                new Rune.RuneInstance(WonderRegistries.RUNES.wrapAsHolder(rune), level)
        )));
        return stack;
    }
}
