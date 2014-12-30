package com.github.soniex2.boatsystems.block;

import com.github.soniex2.boatsystems.init.BSBlocks;
import net.minecraft.block.BlockRedstoneDiode;
import net.minecraft.block.BlockRedstoneRepeater;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * @author soniex2
 */
public class BlockBuoyantRedstoneRepeater extends BlockRedstoneRepeater {
    public BlockBuoyantRedstoneRepeater(boolean on) {
        super(on);
        this.disableStats().setHardness(0.0F).setStepSound(soundTypeWood).setBlockName("diode").setBlockTextureName("repeater_off");
        if (on)
            this.setLightLevel(0.625F).setBlockTextureName("repeater_on");
    }

    @Override
    public boolean canPlaceBlockAt(World w, int x, int y, int z) {
        return w.getBlock(x, y - 1, z).getMaterial() == Material.water && Blocks.waterlily.canPlaceBlockAt(w, x, y, z);
    }

    @Override
    public boolean canBlockStay(World w, int x, int y, int z) {
        return w.getBlock(x, y - 1, z).getMaterial() == Material.water && Blocks.waterlily.canBlockStay(w, x, y, z);
    }

    @Override
    protected BlockRedstoneDiode getBlockPowered() {
        return (BlockRedstoneDiode) BSBlocks.buoyant_powered_redstone_repeater;
    }

    @Override
    protected BlockRedstoneDiode getBlockUnpowered() {
        return (BlockRedstoneDiode) BSBlocks.buoyant_unpowered_redstone_repeater;
    }

    @Override
    public boolean canConnectRedstone(IBlockAccess w, int x, int y, int z, int side) {
        int i = w.getBlockMetadata(x, y, z);
        return side == (i & 3) || side == Direction.rotateOpposite[i & 3];
    }
}
