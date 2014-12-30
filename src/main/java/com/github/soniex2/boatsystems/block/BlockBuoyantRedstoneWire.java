package com.github.soniex2.boatsystems.block;

import net.minecraft.block.BlockRedstoneWire;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import java.util.Random;

/**
 * @author soniex2
 */
public class BlockBuoyantRedstoneWire extends BlockRedstoneWire {

    @Override
    public boolean canPlaceBlockAt(World w, int x, int y, int z) {
        return w.getBlock(x, y - 1, z).getMaterial() == Material.water && Blocks.waterlily.canPlaceBlockAt(w, x, y, z);
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return Item.getItemFromBlock(this);
    }
}
