package fr.kayrouge.wonder.client;

import fr.kayrouge.wonder.Wonder;
import fr.kayrouge.wonder.attachment.ManaAttachment;
import io.wispforest.owo.ui.component.UIComponents;
import io.wispforest.owo.ui.core.Color;
import io.wispforest.owo.ui.core.HorizontalAlignment;
import io.wispforest.owo.ui.core.Positioning;
import io.wispforest.owo.ui.core.VerticalAlignment;
import io.wispforest.owo.ui.hud.Hud;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

public class WonderClient implements ClientModInitializer  {


    @Override
    public void onInitializeClient() {
        Hud.add(Wonder.id("mana"), () -> {

            float mana = -1f;
            float maxMana = -2f;

            if(Minecraft.getInstance().player != null) {
                ManaAttachment.ManaData data = ManaAttachment.get(Minecraft.getInstance().player);

                mana = data.getCurrentMana();
                maxMana = data.getMaxMana();
            }


            return UIComponents.label(Component.literal(mana + "/" + maxMana))
                    .color(Color.ofRgb(0xffffff))
                    .shadow(true)
                    .horizontalTextAlignment(HorizontalAlignment.CENTER)
                    .verticalTextAlignment(VerticalAlignment.CENTER)
                    .positioning(Positioning.absolute(5, 5));
        });
    }
}
