package fr.kayrouge.wonder.client.screen.container;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;

public class TestContainerMenu extends AbstractContainerMenu {

    public TestContainerMenu(final int containerId, final Inventory inventory) {
        super(WonderMenuTypes.TEST, containerId);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slotIndex) {
        return null;
    }

    @Override
    public boolean stillValid(Player player) {
        return false;
    }
}
