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


    @Override
    public @NonNull InteractionResult use(@NonNull Level level, @NonNull Player player, @NonNull InteractionHand hand) {
        if(level.isClientSide()) {
            Minecraft.getInstance().setScreen(new PlayerMenuScreen());
        }
        return super.use(level, player, hand);
    }
}
