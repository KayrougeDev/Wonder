package fr.kayrouge.wonder.client.screen;

import fr.kayrouge.wonder.Wonder;
import fr.kayrouge.wonder.component.PlayerComponent;
import fr.kayrouge.wonder.component.WonderComponents;
import fr.kayrouge.wonder.network.serverbound.ServerboundOpenPlayerMenuPacket;
import io.wispforest.owo.ui.base.BaseUIModelScreen;
import io.wispforest.owo.ui.component.*;
import io.wispforest.owo.ui.container.FlowLayout;
import io.wispforest.owo.ui.container.GridLayout;
import io.wispforest.owo.ui.core.Positioning;
import io.wispforest.owo.ui.core.Sizing;
import net.minecraft.network.chat.Component;

public class PlayerMenuScreen extends BaseUIModelScreen<FlowLayout> {

    public PlayerMenuScreen() {
        super(FlowLayout.class, DataSource.asset(Wonder.id("player_menu")));
    }

    @Override
    protected void build(FlowLayout rootComponent) {
//        EntityComponent<EntityComponent.RenderablePlayerEntity> playerComponent = UIComponents.entity(Sizing.fill(), EntityComponent.createRenderablePlayer(this.minecraft.getGameProfile()));
//
//        playerComponent.scale(0.4f);
//        playerComponent.sizing(Sizing.fill(150), Sizing.fill(90));
//        playerComponent.transform(matrix -> {
//            matrix.translate(0,-0.75f,0);
//        });
//        playerComponent.lookAtCursor(true);


        ButtonComponent openMagicInventory = UIComponents.button(Component.empty(), buttonComponent ->
                    Wonder.CHANNEL.clientHandle().send(new ServerboundOpenPlayerMenuPacket()
                ));
        openMagicInventory.positioning(Positioning.relative(5,75)).sizing(Sizing.fixed(20));
        openMagicInventory.tooltip(Component.translatable("text.wonder.magic_inventory_open"));

        rootComponent.child(openMagicInventory);

    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
