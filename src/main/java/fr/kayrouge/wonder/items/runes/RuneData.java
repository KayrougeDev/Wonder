package fr.kayrouge.wonder.items.runes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.wispforest.owo.ui.core.Color;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipProvider;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public record RuneData(List<Rune.RuneInstance> runes, Optional<Integer> color) implements TooltipProvider {

    public static final Codec<RuneData> CODEC;

    public RuneData(List<Rune.RuneInstance> runes) {
        this(runes, Optional.empty());
    }

    @Override
    public void addToTooltip(Item.TooltipContext context, Consumer<Component> consumer, TooltipFlag flag, DataComponentGetter components) {
        MutableComponent finalComponent = Component.empty();
        runes.forEach(rune -> {
            MutableComponent component = Component.literal(rune.rune().value().getDisplayName() + " "+(rune.level()+1));
            component.withColor(Color.GREEN.rgb());
            finalComponent.append(component);
        });
        consumer.accept(finalComponent);
    }

    static {
        CODEC = RecordCodecBuilder.create(i -> i.group(
                Rune.RuneInstance.CODEC.listOf().fieldOf("runes").forGetter(RuneData::runes),
                Codec.INT.optionalFieldOf("color").forGetter(RuneData::color)
        ).apply(i, RuneData::new));
    }
}
