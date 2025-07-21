package com.kielson.item;

import com.kielson.util.ItemHelper;
import net.minecraft.item.Item;

import static com.kielson.RingsAndThings.MOD_ID;

public class RingsAndThingsItems{
    public static final Item RING = ItemHelper.registerItem(MOD_ID, "ring", RingItem::new, new Item.Settings());


    public static void initialize() {}
}
