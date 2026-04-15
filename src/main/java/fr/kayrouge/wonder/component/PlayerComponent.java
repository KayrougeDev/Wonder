package fr.kayrouge.wonder.component;

import com.mojang.serialization.Codec;
import fr.kayrouge.wonder.endec.WonderEndecs;
import fr.kayrouge.wonder.menu.MagicInventoryMenu;
import io.wispforest.endec.SerializationAttribute;
import io.wispforest.endec.SerializationContext;
import io.wispforest.endec.format.bytebuf.ByteBufDeserializer;
import io.wispforest.endec.format.bytebuf.ByteBufSerializer;
import io.wispforest.endec.impl.KeyedEndec;
import io.wispforest.owo.serialization.CodecUtils;
import io.wispforest.owo.serialization.endec.MinecraftEndecs;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;
import org.ladysnake.cca.api.v8.component.CardinalComponent;

public class PlayerComponent implements AutoSyncedComponent {

    private final Player player;
    private SimpleContainer magicInventory;

    private final KeyedEndec<SimpleContainer> inventoryEndec = WonderEndecs.containerEndec(MagicInventoryMenu.MAGIC_INVENTORY_SIZE)
            .keyed("inventory", new SimpleContainer(MagicInventoryMenu.MAGIC_INVENTORY_SIZE));

    private final Codec<SimpleContainer> inventoryCodec = CodecUtils.toCodec(inventoryEndec.endec());

    @Override
    public void applySyncPacket(RegistryFriendlyByteBuf buf) {
        this.magicInventory = buf.readLenientJsonWithCodec(inventoryCodec);
    }

    @Override
    public void writeSyncPacket(RegistryFriendlyByteBuf buf, ServerPlayer recipient) {
        buf.writeJsonWithCodec(inventoryCodec, this.magicInventory);
    }

    @Override
    public boolean shouldSyncWith(ServerPlayer player) {
        return player == this.player;
    }

    public PlayerComponent(Player player) {
        this.player = player;
        this.magicInventory = inventoryEndec.defaultValue();
    }

    @Override
    public void readData(ValueInput readView) {
        this.magicInventory = readView.get(inventoryEndec);
    }

    @Override
    public void writeData(ValueOutput writeView) {
        writeView.put(inventoryEndec,  magicInventory);
    }

    public SimpleContainer getMagicInventory() {
        return magicInventory;
    }
}
