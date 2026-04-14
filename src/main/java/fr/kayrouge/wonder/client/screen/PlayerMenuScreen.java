package fr.kayrouge.wonder.client.screen;

import fr.kayrouge.wonder.Wonder;
import io.wispforest.owo.ui.base.BaseOwoContainerScreen;
import io.wispforest.owo.ui.base.BaseUIModelScreen;
import io.wispforest.owo.ui.component.ButtonComponent;
import io.wispforest.owo.ui.component.EntityComponent;
import io.wispforest.owo.ui.component.LabelComponent;
import io.wispforest.owo.ui.component.UIComponents;
import io.wispforest.owo.ui.container.FlowLayout;
import io.wispforest.owo.ui.core.Sizing;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

public class PlayerMenuScreen extends BaseUIModelScreen<FlowLayout> {

    public PlayerMenuScreen() {
        super(FlowLayout.class, DataSource.asset(Wonder.id("player_menu")));
    }

    @Override
    protected void build(FlowLayout rootComponent) {
        EntityComponent<EntityComponent.RenderablePlayerEntity> playerComponent = UIComponents.entity(Sizing.fill(), EntityComponent.createRenderablePlayer(Minecraft.getInstance().getGameProfile()));

        playerComponent.scale(0.4f);
        playerComponent.sizing(Sizing.fill(150), Sizing.fill(90));
        playerComponent.transform(matrix -> {
            matrix.translate(0,-0.75f,0);
        });
        playerComponent.lookAtCursor(true);

        rootComponent.childById(FlowLayout.class, "player-display").child(playerComponent);

        Component playerName = playerComponent.entity().getDisplayName().plainCopy();
        LabelComponent playerNameComponent = UIComponents.label(playerName).shadow(true);
        rootComponent.childById(FlowLayout.class, "player-display").child(playerNameComponent);

        rootComponent.childById(ButtonComponent.class, "inspector-toggle").onPress(buttonComponent -> {
            this.uiAdapter.toggleInspector();
        });
    }

    @Override
    public boolean isPauseScreen() {

        return false;
    }
}
