package com.kielson.block.entity;

import com.kielson.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class JewelryTableBlockEntity extends BlockEntity {
    public JewelryTableBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlocks.ModBlockEntities.JEWELRY_TABLE_BLOCK_ENTITY, pos, state);
    }
}
