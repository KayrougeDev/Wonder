package fr.kayrouge.wonder.menu.slot;

import fr.kayrouge.wonder.items.WonderItems;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class RuneSlot extends Slot {

    public RuneSlot(Container container, int slot, int x, int y) {
        super(container, slot, x, y);
    }

    @Override
    public boolean mayPlace(ItemStack itemStack) {
        return itemStack.getItem().equals(WonderItems.RUNE);
    }
}
