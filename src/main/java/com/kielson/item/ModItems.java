package com.kielson.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.kielson.KielsonsJewelry.MOD_ID;

public class ModItems {
    public static final Item RING = register("ring", new RingItem());


    public static Item register(String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MOD_ID, id), item);
    }

    public static void registerModItems() {int x = 1;}
}
