package com.kielson.item;

import com.kielson.block.RingsAndThingsBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.DyedColorComponent;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static com.kielson.RingsAndThings.MOD_ID;

public class RingsAndThingsItemGroups {
    public static final ItemGroup RINGS_AND_THINGS = Registry.register(Registries.ITEM_GROUP, Identifier.of(MOD_ID, MOD_ID),
        FabricItemGroup.builder().displayName(Text.translatable("itemGroup." + MOD_ID)).icon(() -> {
            ItemStack itemStack = new ItemStack(RingsAndThingsItems.RING);
            //RingItem.setEffect(itemStack, RingItem.RingEffects.NONE);
            //RingItem.setMaterial(itemStack, RingItem.RingMaterials.BAMBOO);
            itemStack.set(DataComponentTypes.DYED_COLOR, new DyedColorComponent(0xFF55FFFF));
            return itemStack;
        }).entries((displayContext, entries) -> {

            entries.add(RingsAndThingsBlocks.JEWELRY_TABLE.asItem());

            //Rings
            //addRings(entries);
            entries.add(RingsAndThingsItems.RING);

        }).build());


    public static void initialize() {
        addItemsToFunctional();
    }

    /*private static void addRings(ItemGroup.Entries entries) {
        for (RingItem.RingMaterials material : RingItem.RingMaterials.values()) {
            for (RingItem.RingEffects effect : RingItem.RingEffects.values()){
                ItemStack itemStack = new ItemStack(ModItems.RING);
                RingItem.setEffect(itemStack, effect);
                RingItem.setMaterial(itemStack, material);
                RingItem.setRandomColor(itemStack);
                entries.add(itemStack, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
            }
        }
    }*/

    private static void addItemsToFunctional(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> {
            content.addAfter(Items.BREWING_STAND, RingsAndThingsBlocks.JEWELRY_TABLE.asItem());
        });
    }
}

