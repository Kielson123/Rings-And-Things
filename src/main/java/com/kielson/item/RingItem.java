package com.kielson.item;

import com.kielson.KielsonsAPIComponents;
import com.kielson.KielsonsEntityAttributes;
import com.kielson.util.RingComponent;
import com.mojang.serialization.Codec;
import net.minecraft.component.ComponentType;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.DyedColorComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.text.TextCodecs;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.*;

import static com.kielson.RingsAndThings.MOD_ID;


public class RingItem extends Item{
    public static final ComponentType<RingComponent> RING_COMPONENT = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(MOD_ID, "ring"),
            ComponentType.<RingComponent>builder().codec(RingComponent.CODEC).build()
    );
    public static final Identifier RING_MODIFIER_ID = Identifier.of(MOD_ID, "ring_modifier");

    public RingItem(Settings settings) {
        super(settings.maxCount(1).rarity(Rarity.UNCOMMON)
                .component(RING_COMPONENT, new RingComponent("gold", ""))
                .component(DataComponentTypes.DYED_COLOR, new DyedColorComponent(0xFFFFFF)));
    }

    /*private static AttributeModifiersComponent createAttributeModifiers(ItemStack itemStack) {
        RingEffects ringEffect = RingEffects.valueOf(itemStack.getOrDefault(RING_EFFECT, Text.literal("")).getString().toUpperCase());
        AttributeModifiersComponent.Builder builder = AttributeModifiersComponent.builder();
        builder.add(ringEffect.attribute.entityAttribute, new EntityAttributeModifier(RING_MODIFIER_ID, ringEffect.attribute.value, ringEffect.attribute.operation), AttributeModifierSlot.OFFHAND);
        return builder.build();
    }

    @Override
    public ItemStack getDefaultStack() {
        ItemStack itemStack = new ItemStack(this);
        RingItem.setMaterial(itemStack, RingMaterials.STONE);
        RingItem.setEffect(itemStack, RingEffects.NONE);
        RingItem.setRandomColor(itemStack);
        return itemStack;
    }

    @Override
    public String getTranslationKey(ItemStack stack) {
        String materialName = stack.getOrDefault(RING_MATERIAL, Text.literal("")).getString().toLowerCase();
        return "item." + MOD_ID + ".ring.name." + materialName;
    }

    ItemStack previousStack = ItemStack.EMPTY;

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (previousStack != ItemStack.EMPTY && (!Objects.equals(stack.get(RING_EFFECT), previousStack.get(RING_EFFECT)))){
            stack.set(DataComponentTypes.ATTRIBUTE_MODIFIERS, createAttributeModifiers(stack));
        }
        previousStack = stack;
    }

    public static void setMaterial(@NotNull ItemStack stack, @NotNull RingMaterials ringMaterial) {
        stack.set(RING_MATERIAL, Text.literal(ringMaterial.toString().toLowerCase()));
    }

    public static void setEffect(@NotNull ItemStack stack, @NotNull RingItem.RingEffects ringGem) {
        stack.set(RING_EFFECT, Text.literal(ringGem.toString().toLowerCase()));
        stack.set(DataComponentTypes.ATTRIBUTE_MODIFIERS, createAttributeModifiers(stack));
    }

    public static void setRandomColor(@NotNull ItemStack stack) {
        stack.set(DataComponentTypes.DYED_COLOR, new DyedColorComponent((new Random().nextInt(0, 0xFFFFFF)) + 0xFF000000, false));
    }*/

    public enum RingMaterials{
        STONE(0.1f),
        COPPER(0.2f),
        IRON(0.3f),
        GOLD(0.4f),
        NETHERITE(0.5f),
        BAMBOO(0.6f),
        WOOD(0.7f);

        public final float modelPredicateProvider;

        RingMaterials(float modelPredicateProvider) {
            this.modelPredicateProvider = modelPredicateProvider;
        }
    }
    public enum RingEffects {
        NONE(new RingAttribute(KielsonsEntityAttributes.ITEM_PICK_UP_RANGE, -10, EntityAttributeModifier.Operation.ADD_VALUE));

        private final RingAttribute attribute;

        RingEffects(RingAttribute attribute) {
            this.attribute = attribute;
        }
    }

    private record RingAttribute(RegistryEntry<EntityAttribute> entityAttribute, double value, EntityAttributeModifier.Operation operation){}
}
