package org.winglessbirds.dhsnowfix.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.SnowBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SnowBlock.class)
public abstract class SnowBlockMixin extends Block {

    public SnowBlockMixin (Settings settings) {
        super(settings);
    }

    public boolean isTransparent (BlockView world, BlockPos pos) {
        return true; // this is one of the two things required for Distant Horizons to avoid this block
    } // this however makes snow let all light completely through

}
