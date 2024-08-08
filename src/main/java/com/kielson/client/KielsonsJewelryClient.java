package com.kielson.client;

import com.kielson.item.ModItems;
import com.kielson.item.RingItem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.util.Identifier;

import java.util.Objects;

import static com.kielson.KielsonsJewelry.MOD_ID;

public class KielsonsJewelryClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerModelPredicateProviders();

        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> stack.get(DataComponentTypes.DYED_COLOR).rgb() + 0xFF000000, ModItems.RING);
    }

    private void registerModelPredicateProviders(){
        ModelPredicateProviderRegistry.register(ModItems.RING, Identifier.of(MOD_ID, "material"), (itemStack, clientWorld, livingEntity, seed) -> {
            RingItem.RingMaterials ringMaterial = RingItem.RingMaterials.valueOf(Objects.requireNonNull(itemStack.get(RingItem.RING_MATERIAL)).getString().toUpperCase());
            return ringMaterial.modelPredicateProvider;
        });
    }
}
