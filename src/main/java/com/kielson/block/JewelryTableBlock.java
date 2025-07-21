package com.kielson.block;

import com.kielson.util.RingsAndThingsStats;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static com.kielson.RingsAndThings.MOD_ID;

public class JewelryTableBlock extends Block{
    public static final MapCodec<JewelryTableBlock> CODEC = createCodec(JewelryTableBlock::new);
    private static final Text TITLE = Text.translatable("container." + MOD_ID + ".jewelry");

    public JewelryTableBlock(Settings settings) {
        super(settings.mapColor(MapColor.OFF_WHITE).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(0.8F));
    }

    @Override
    public MapCodec<? extends JewelryTableBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isClient) {
            return ActionResult.SUCCESS;
        } else {
            player.openHandledScreen(state.createScreenHandlerFactory(world, pos));
            player.incrementStat(RingsAndThingsStats.INTERACT_WITH_JEWELRY_TABLE);
            return ActionResult.CONSUME;
        }
    }

    /*@Override
    protected NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return new SimpleNamedScreenHandlerFactory((syncId, inventory, player) -> new JewelryScreenHandler(syncId, inventory, (PacketByteBuf) ScreenHandlerContext.create(world, pos)), TITLE);
    }*/
}
