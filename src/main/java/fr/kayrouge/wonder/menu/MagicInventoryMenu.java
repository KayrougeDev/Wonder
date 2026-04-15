package fr.kayrouge.wonder.menu;

import fr.kayrouge.wonder.component.WonderComponents;
import fr.kayrouge.wonder.menu.slot.RuneSlot;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class MagicInventoryMenu extends AbstractContainerMenu {
    private final Container magicInventory;
    private final Player player;

    public static final int MAGIC_INVENTORY_SIZE = 5;

    public MagicInventoryMenu(final int containerId, final Inventory inventory, Container magicInventory) {
        super(WonderMenuTypes.MAGIC_INVENTORY, containerId);
        this.magicInventory = magicInventory;
        this.player = inventory.player;

        for (int i = 0; i < MAGIC_INVENTORY_SIZE; i++) {
            this.addSlot(new RuneSlot(magicInventory, i,0,5*i));
        }

        this.addStandardInventorySlots(inventory, 8, 84);
    }

    @Override
    public void broadcastChanges() {
        super.broadcastChanges();
        WonderComponents.PLAYER.sync(this.player);
    }

    public MagicInventoryMenu(final int containerId, final Inventory inventory) {
        this(containerId, inventory, new SimpleContainer(MAGIC_INVENTORY_SIZE));
    }


    @Override
    public ItemStack quickMoveStack(Player player, int slotIndex) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player player) {
        return this.magicInventory.stillValid(player);
    }
}
