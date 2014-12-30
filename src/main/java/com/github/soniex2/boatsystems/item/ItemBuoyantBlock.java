package com.github.soniex2.boatsystems.item;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.util.BlockSnapshot;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.event.ForgeEventFactory;

/**
 * @author soniex2
 */
public class ItemBuoyantBlock extends ItemBlock {
    public ItemBuoyantBlock(Block b) {
        super(b);
    }

    @Override
    public boolean onItemUse(ItemStack is, EntityPlayer p, World w, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        // TODO fix this
        return super.onItemUse(is, p, w, x, y, z, side, hitX, hitY, hitZ);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack is, World w, EntityPlayer p) {
        // TODO fix this (aka merge it with onItemUse somehow)
        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(w, p, true);

        if (movingobjectposition == null) {
            return is;
        } else {
            if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
                int i = movingobjectposition.blockX;
                int j = movingobjectposition.blockY;
                int k = movingobjectposition.blockZ;

                if (!w.canMineBlock(p, i, j, k)) {
                    return is;
                }

                if (!p.canPlayerEdit(i, j, k, movingobjectposition.sideHit, is)) {
                    return is;
                }

                if (w.getBlock(i, j, k).getMaterial() == Material.water && w.getBlockMetadata(i, j, k) == 0 && w.isAirBlock(i, j + 1, k)) {
                    // special case for handling block placement with water lilies
                    BlockSnapshot blocksnapshot = BlockSnapshot.getBlockSnapshot(w, i, j + 1, k);
                    w.setBlock(i, j + 1, k, this.field_150939_a);
                    if (ForgeEventFactory.onPlayerBlockPlace(p, blocksnapshot, ForgeDirection.UP).isCanceled()) {
                        blocksnapshot.restore(true, false);
                        return is;
                    }

                    if (!p.capabilities.isCreativeMode) {
                        --is.stackSize;
                    }
                }
            }

            return is;
        }
    }
}
