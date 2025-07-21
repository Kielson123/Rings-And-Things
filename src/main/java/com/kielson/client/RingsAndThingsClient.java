package com.kielson.client;

import net.fabricmc.api.ClientModInitializer;

public class RingsAndThingsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        /*registerModelPredicateProviders();

        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
            if (tintIndex == 0){
                return stack.get(DataComponentTypes.DYED_COLOR).rgb() + 0xFF000000;
            }
            return 0xFFFFFFFF;
        }, ModItems.RING);
    }

    private void registerModelPredicateProviders(){
        ModelPredicateProviderRegistry.register(ModItems.RING, Identifier.of(MOD_ID, "material"), (itemStack, clientWorld, livingEntity, seed) -> {
            RingItem.RingMaterials ringMaterial = RingItem.RingMaterials.valueOf(Objects.requireNonNull(itemStack.get(RingItem.RING_MATERIAL)).getString().toUpperCase());
            return ringMaterial.modelPredicateProvider;
        });*/
    }
}
