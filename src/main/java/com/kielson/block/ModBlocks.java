package com.kielson.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.kielson.KielsonsJewelry.MOD_ID;

public class ModBlocks {

    public static final Block JEWELRY_TABLE = register(new JewelryTableBlock(AbstractBlock.Settings.create()), "jewelry_table", true);

    public static Block register(Block block, String name, boolean shouldRegisterItem) {
        Identifier id = Identifier.of(MOD_ID, name);
        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }
        return Registry.register(Registries.BLOCK, id, block);
    }

    public static void initialize() {}
}
