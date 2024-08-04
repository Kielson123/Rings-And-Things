package com.kielson.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static com.kielson.KielsonsJewelry.MOD_ID;

public class ModItemGroups {
    public static final ItemGroup KIELSONS_JEWELRY = Registry.register(Registries.ITEM_GROUP, Identifier.of(MOD_ID, MOD_ID),
        FabricItemGroup.builder().displayName(Text.literal("_Kielson's Jewelry")).icon(() -> {
            ItemStack itemStack = new ItemStack(ModItems.RING);
            RingItem.setEffect(itemStack, RingItem.RingEffects.NONE);
            RingItem.setMaterial(itemStack, RingItem.RingMaterials.BAMBOO);
            return itemStack;
        }).entries((displayContext, entries) -> {

            //Rings
            addRings(entries);

        }).build());

    public static void registerItemGroups() {
        int x = 1;
    }

    private static void addRings(ItemGroup.Entries entries) {
        for (RingItem.RingMaterials material : RingItem.RingMaterials.values()) {
            for (RingItem.RingEffects gem : RingItem.RingEffects.values()){
                ItemStack itemStack = new ItemStack(ModItems.RING);
                RingItem.setEffect(itemStack, gem);
                RingItem.setMaterial(itemStack, material);
                entries.add(itemStack, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
            }
        }
    }
}

