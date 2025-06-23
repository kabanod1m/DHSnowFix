package org.winglessbirds.dhsnowfix.mixin.client;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SnowBlock;
import net.minecraft.item.ItemConvertible;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Block.class)
public abstract class BlockMixin extends AbstractBlock implements ItemConvertible {

    public BlockMixin (Settings settings) {
        super(settings);
    }

    @Redirect(method = "shouldDrawSide(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/BlockView;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/Direction;Lnet/minecraft/util/math/BlockPos;)Z", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOpaque()Z"))
    private static boolean inject_shouldDrawSide_isOpaque (BlockState instance) { // this is still pretty bad for performance but this fixes faces between snow layers being next to each other being drawn
        if (instance.getBlock() instanceof SnowBlock) return true;
        return instance.isOpaque();
    } // basically every time method "shouldDrawSide" calls "isOpaque" for currently inspected block it also checks if it's snow layer and if it is it assumes it's opaque; yes it's +1 check every single time :(

}
