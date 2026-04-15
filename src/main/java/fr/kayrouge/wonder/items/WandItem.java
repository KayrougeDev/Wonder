package fr.kayrouge.wonder.items;

import fr.kayrouge.wonder.client.screen.PlayerMenuScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;

public class WandItem extends Item {

    public WandItem(Properties properties) {
        super(properties.stacksTo(1));
    }

}
