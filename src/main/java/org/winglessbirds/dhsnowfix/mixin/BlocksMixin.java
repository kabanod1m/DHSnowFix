package org.winglessbirds.dhsnowfix.mixin;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(Blocks.class)
public abstract class BlocksMixin {

    @Redirect(
            method = "<clinit>()V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;create()Lnet/minecraft/block/AbstractBlock$Settings;"),
            slice = @Slice(
                    from = @At(value = "NEW", target = "Lnet/minecraft/block/SnowBlock;"),
                    to = @At(value = "FIELD", target = "Lnet/minecraft/block/Blocks;SNOW:Lnet/minecraft/block/Block;", opcode = Opcodes.PUTSTATIC)
            )
    )
    private static AbstractBlock.Settings inject_create () {
        return AbstractBlock.Settings.create()
                .nonOpaque(); // this is one of the two things required for Distant Horizons to avoid this block
    } // this however makes the renderer render all sides of the snow layer, including those which are next to other snow layer blocks, see the fix to this in client.BlockMixin

}
