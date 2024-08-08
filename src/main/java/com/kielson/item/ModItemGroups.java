package com.kielson.item;

import com.kielson.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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

            entries.add(ModBlocks.JEWELRY_TABLE.asItem());

            //Rings
            addRings(entries);

        }).build());


    public static void initialize() {
        addItemsToFunctional();
    }

    private static void addRings(ItemGroup.Entries entries) {
        for (RingItem.RingMaterials material : RingItem.RingMaterials.values()) {
            for (RingItem.RingEffects effect : RingItem.RingEffects.values()){
                ItemStack itemStack = new ItemStack(ModItems.RING);
                RingItem.setEffect(itemStack, effect);
                RingItem.setMaterial(itemStack, material);
                entries.add(itemStack, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
            }
        }
    }

    private static void addItemsToFunctional(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> {
            content.addAfter(Items.BREWING_STAND, ModBlocks.JEWELRY_TABLE.asItem());
        });
    }
}

