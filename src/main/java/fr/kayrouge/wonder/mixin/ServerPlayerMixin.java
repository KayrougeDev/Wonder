package fr.kayrouge.wonder.mixin;

import fr.kayrouge.wonder.component.WonderComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.gamerules.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayer.class)
public abstract class ServerPlayerMixin {

    @Shadow
    public abstract ServerLevel level();

    @Inject(method = "die", at = @At("TAIL"))
    public void die(DamageSource source, CallbackInfo ci) {
        ServerPlayer player = (ServerPlayer) (Object)this;

        if (!level().getGameRules().get(GameRules.KEEP_INVENTORY)){
            WonderComponents.PLAYER.get(player).getMagicInventory().items.forEach(itemStack -> {
                player.spawnAtLocation(level(), itemStack);
            });
        }
    }
}
