package fr.kayrouge.wonder.items.runes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import fr.kayrouge.wonder.WonderRegistries;
import fr.kayrouge.wonder.items.WonderItems;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

public record Rune(int color) {

    public static final Codec<Holder<Rune>> CODEC = WonderRegistries.RUNES.holderByNameCodec();

    // TODO test
    public void tick(ServerPlayer player, int level) {
        player.sendSystemMessage(Component.literal("ticked ").append(getDisplayName()));
    }

    // TODO implement
    public void onEquipped(Player player, int level) {
        player.sendSystemMessage(Component.literal("equip ").append(getDisplayName()));
    }

    // TODO implement
    public void onUnequipped(Player player, int level) {
        player.sendSystemMessage(Component.literal("unequip ").append(getDisplayName()));
    }

    public Component getDisplayName() {
        Identifier id = WonderRegistries.RUNES.getKey(this);
        if (id == null) {return Component.empty();}
        return Component.translatable("rune."+id.getNamespace()+"."+id.getPath());
    }


    public record RuneInstance(Holder<Rune> rune, int level) {
        public static final Codec<RuneInstance> CODEC
                = RecordCodecBuilder.create(i -> i.group(
                        Rune.CODEC.fieldOf("rune").forGetter(RuneInstance::rune),
                        Codec.INT.fieldOf("level").forGetter(RuneInstance::level)
        ).apply(i, RuneInstance::new));
    }
}

