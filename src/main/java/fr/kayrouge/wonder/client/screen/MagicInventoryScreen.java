package fr.kayrouge.wonder.client.screen;

import fr.kayrouge.wonder.Wonder;
import fr.kayrouge.wonder.menu.MagicInventoryMenu;
import io.wispforest.owo.braid.widgets.basic.LayoutBuilder;
import io.wispforest.owo.braid.widgets.grid.Grid;
import io.wispforest.owo.ui.base.BaseUIModelContainerScreen;
import io.wispforest.owo.ui.base.BaseUIModelScreen;
import io.wispforest.owo.ui.component.ButtonComponent;
import io.wispforest.owo.ui.component.LabelComponent;
import io.wispforest.owo.ui.component.TextureComponent;
import io.wispforest.owo.ui.component.UIComponents;
import io.wispforest.owo.ui.container.*;
import io.wispforest.owo.ui.core.*;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.Containers;
import net.minecraft.world.entity.player.Inventory;

import java.util.List;
import java.util.stream.Stream;

public class MagicInventoryScreen extends BaseUIModelContainerScreen<FlowLayout, MagicInventoryMenu> {

    public MagicInventoryScreen(MagicInventoryMenu handler, Inventory inventory, final Component title) {
        super(handler, inventory, title, FlowLayout.class, BaseUIModelScreen.DataSource.asset(Wonder.id("magic_inventory")));
    }

    @Override
    protected void build(FlowLayout rootComponent) {
        final int magicInvSize = MagicInventoryMenu.MAGIC_INVENTORY_SIZE;
        final Identifier slotBackgroundId = Wonder.id("textures/gui/slot.png");

        GridLayout equippedRuneGrid = rootComponent.childById(GridLayout.class, "equipped-runes-grid");
        equippedRuneGrid.layout(Size.of(magicInvSize,1));

        for (int i = 0; i < magicInvSize; i++) {
            SlotComponent s = slotAsComponent(i);

            TextureComponent bg = UIComponents.texture(slotBackgroundId, 0, 0, 18, 18, 18, 18);
            StackLayout stack = UIContainers.stack(Sizing.fixed(18), Sizing.fixed(18));

            s.margins(Insets.of(1,0,1,0));

            stack.child(bg);
            stack.child(s);

            equippedRuneGrid.child(stack, 0, i);
        }

        // TODO replace with a smaller area with a scroll container and only shows in inventory runes
        GridLayout playerInventoryGrid = rootComponent.childById(GridLayout.class, "player-inventory-grid");

        int index = magicInvSize;
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 6; x++) {
                SlotComponent s = slotAsComponent(index);

                TextureComponent bg = UIComponents.texture(slotBackgroundId, 0, 0, 18, 18, 18, 18);
                StackLayout stack = UIContainers.stack(Sizing.fixed(18), Sizing.fixed(18));

                s.margins(Insets.of(1,0,1,0));

                stack.child(bg);
                stack.child(s);

                playerInventoryGrid.child(stack, y, x);
                index++;
            }
        }


    }

    @Override
    protected void extractLabels(GuiGraphicsExtractor graphics, int xm, int ym) {
    }
}
