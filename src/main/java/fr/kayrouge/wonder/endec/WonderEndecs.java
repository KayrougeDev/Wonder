package fr.kayrouge.wonder.endec;

import io.wispforest.endec.Endec;
import io.wispforest.endec.impl.KeyedEndec;
import io.wispforest.owo.serialization.endec.MinecraftEndecs;
import io.wispforest.owo.serialization.endec.NonNullListEndec;
import net.minecraft.core.NonNullList;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;

public class WonderEndecs {

    public static Endec<SimpleContainer> containerEndec(Endec<NonNullList<ItemStack>> endec) {
        return Endec.of((ctx, serializer, value) -> {
            endec.encode(ctx, serializer, value.getItems());
        }, (ctx, deserializer) -> new SimpleContainer(endec.decode(ctx,deserializer).toArray(new ItemStack[0])));
    }

    public static Endec<SimpleContainer> containerEndec(int size) {
        return containerEndec(NonNullListEndec.forSize(MinecraftEndecs.ITEM_STACK, ItemStack.EMPTY, size));
    }

}
