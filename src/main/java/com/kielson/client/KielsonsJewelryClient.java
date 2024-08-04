package com.kielson.client;

import com.kielson.item.ModItems;
import com.kielson.item.RingItem;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

import java.util.Objects;

public class KielsonsJewelryClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerModelPredicateProviders();
    }

    private void registerModelPredicateProviders(){
        ModelPredicateProviderRegistry.register(ModItems.RING, Identifier.of("material"), (itemStack, clientWorld, livingEntity, seed) -> {
            RingItem.RingMaterials ringMaterial = RingItem.RingMaterials.valueOf(Objects.requireNonNull(itemStack.get(RingItem.RING_MATERIAL)).getString().toUpperCase());
            return ringMaterial.modelPredicateProvider;
        });
    }
}
