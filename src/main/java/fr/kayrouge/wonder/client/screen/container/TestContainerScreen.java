package fr.kayrouge.wonder.client.screen.container;

import fr.kayrouge.wonder.Wonder;
import io.wispforest.owo.ui.base.BaseUIModelContainerScreen;
import io.wispforest.owo.ui.base.BaseUIModelScreen;
import io.wispforest.owo.ui.container.FlowLayout;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class TestContainerScreen extends BaseUIModelContainerScreen<FlowLayout, TestContainerMenu> {

    protected TestContainerScreen(TestContainerMenu handler, Inventory inventory) {
        super(handler, inventory, Component.literal("Test Menu"), FlowLayout.class, BaseUIModelScreen.DataSource.asset(Wonder.id("test_container")));
    }

    @Override
    protected void build(FlowLayout rootComponent) {

    }
}
