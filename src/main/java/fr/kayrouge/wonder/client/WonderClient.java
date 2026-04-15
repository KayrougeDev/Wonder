package fr.kayrouge.wonder.client;

import fr.kayrouge.wonder.Wonder;
import fr.kayrouge.wonder.client.screen.PlayerMenuScreen;
import fr.kayrouge.wonder.client.screen.MagicInventoryScreen;
import fr.kayrouge.wonder.menu.WonderMenuTypes;
import fr.kayrouge.wonder.network.serverbound.ServerboundOpenPlayerMenuPacket;
import io.wispforest.owo.braid.core.Insets;
import io.wispforest.owo.braid.framework.proxy.WidgetProxy;
import io.wispforest.owo.braid.framework.widget.Widget;
import io.wispforest.owo.braid.util.BraidToast;
import io.wispforest.owo.braid.widgets.Navigator;
import io.wispforest.owo.braid.widgets.basic.*;
import io.wispforest.owo.braid.widgets.button.MessageButton;
import io.wispforest.owo.braid.widgets.flex.Column;
import io.wispforest.owo.braid.widgets.flex.CrossAxisAlignment;
import io.wispforest.owo.braid.widgets.flex.MainAxisAlignment;
import io.wispforest.owo.braid.widgets.textinput.TextBox;
import io.wispforest.owo.ui.base.BaseOwoToast;
import io.wispforest.owo.ui.component.UIComponents;
import io.wispforest.owo.ui.core.Color;
import io.wispforest.owo.ui.core.HorizontalAlignment;
import io.wispforest.owo.ui.core.Positioning;
import io.wispforest.owo.ui.core.VerticalAlignment;
import io.wispforest.owo.ui.hud.Hud;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.gui.components.toasts.Toast;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.boss.enderdragon.DragonFlightHistory;
import org.lwjgl.glfw.GLFW;

import java.time.Duration;
import java.util.List;

public class WonderClient implements ClientModInitializer  {


    public static final KeyMapping OPEN_SCREEN = new KeyMapping(Wonder.MOD_ID + ".key.open_menu", GLFW.GLFW_KEY_M, KeyMapping.Category.GAMEPLAY);
    public static final KeyMapping TEST = new KeyMapping(Wonder.MOD_ID + ".key.test", GLFW.GLFW_KEY_N, KeyMapping.Category.GAMEPLAY);

    @Override
    public void onInitializeClient() {

        MenuScreens.register(WonderMenuTypes.MAGIC_INVENTORY, MagicInventoryScreen::new);

        Hud.add(Wonder.id("mana"), () -> {

            float mana = -1f;
            float maxMana = -2f;

            return UIComponents.label(Component.literal(mana + "/" + maxMana))
                    .color(Color.ofRgb(0xffffff))
                    .shadow(true)
                    .horizontalTextAlignment(HorizontalAlignment.CENTER)
                    .verticalTextAlignment(VerticalAlignment.CENTER)
                    .positioning(Positioning.absolute(5, 5));
        });

        KeyMappingHelper.registerKeyMapping(OPEN_SCREEN);
        ClientTickEvents.START_CLIENT_TICK.register((client) -> {
            while (OPEN_SCREEN.consumeClick()) {
                client.setScreen(new PlayerMenuScreen());
            }
            while (TEST.consumeClick()) {
                Wonder.CHANNEL.clientHandle().send(new ServerboundOpenPlayerMenuPacket());
            }
        });
    }
}
