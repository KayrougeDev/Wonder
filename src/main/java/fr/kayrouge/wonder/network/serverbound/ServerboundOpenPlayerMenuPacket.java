package fr.kayrouge.wonder.network.serverbound;

import fr.kayrouge.wonder.Wonder;
import fr.kayrouge.wonder.menu.MagicInventoryMenu;
import fr.kayrouge.wonder.component.WonderComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import org.jspecify.annotations.NonNull;

public record ServerboundOpenPlayerMenuPacket() {

    public static void register() {
        Wonder.CHANNEL.registerServerbound(ServerboundOpenPlayerMenuPacket.class, (message, access) -> {
            access.player().openMenu(new MenuProvider() {
                @Override
                public @NonNull Component getDisplayName() {
                    return Component.empty();
                }

                @Override
                public @NonNull AbstractContainerMenu createMenu(int containerId, @NonNull Inventory inventory, @NonNull Player player) {
                    SimpleContainer container = WonderComponents.PLAYER.get(player).getMagicInventory();
                    return new MagicInventoryMenu(containerId, inventory, container);
                }
            });
        });
    }
}
