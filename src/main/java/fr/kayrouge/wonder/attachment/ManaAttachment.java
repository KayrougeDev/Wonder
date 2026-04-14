package fr.kayrouge.wonder.attachment;

import com.mojang.serialization.Codec;
import fr.kayrouge.wonder.Wonder;
import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentSyncPredicate;
import net.fabricmc.fabric.api.attachment.v1.AttachmentTarget;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;

public class ManaAttachment {

    public static final AttachmentType<Float> MANA = AttachmentRegistry.create(
            Identifier.fromNamespaceAndPath(Wonder.MOD_ID, "mana_attachment"),
            builder -> builder
                    .initializer(() -> 0f)
                    .persistent(Codec.FLOAT)
                    .syncWith(
                            ByteBufCodecs.FLOAT,
                            AttachmentSyncPredicate.targetOnly()
                    )
    );

    public static final AttachmentType<Float> MANA_MAX= AttachmentRegistry.create(
            Identifier.fromNamespaceAndPath(Wonder.MOD_ID, "mana_max_attachment"),
            builder -> builder
                    .initializer(() -> 0f)
                    .persistent(Codec.FLOAT)
                    .syncWith(
                            ByteBufCodecs.FLOAT,
                            AttachmentSyncPredicate.targetOnly()
                    )
    );

    public static final AttachmentType<ItemStack> ITEM = AttachmentRegistry.create(
            Identifier.fromNamespaceAndPath(Wonder.MOD_ID, "mana_item_attachment"),
            builder -> builder
                    .initializer(() -> ItemStack.EMPTY)
                    .persistent(ItemStack.CODEC)
                    .syncWith(
                            ItemStack.STREAM_CODEC,
                            AttachmentSyncPredicate.targetOnly()
                    )
    );

    public static ManaData get(AttachmentTarget target) {
        return new ManaData(target);
    }


    public record ManaData(AttachmentTarget target) {

        public float getCurrentMana() {
            return target.getAttachedOrElse(MANA, 0f);
        }

        public float decrementCurrentMana(float amount) {
            return target.modifyAttached(MANA, currentStamina -> currentStamina-amount);
        }

        public void setCurrentMana(float value) {
            target.setAttached(MANA, value);
        }

        public float getMaxMana() {
            return target.getAttachedOrElse(MANA_MAX, 0f);
        }

        public void setMaxMana(float value) {
            target.setAttached(MANA_MAX, value);
        }

        public ItemStack getItem() {
            return target.getAttached(ITEM);
        }

        public void setItem(ItemStack stack) {
            target.modifyAttached(ITEM, itemStack -> stack);
        }

    }

}
