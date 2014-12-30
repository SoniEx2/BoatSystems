package com.github.soniex2.boatsystems.item;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 * @author soniex2
 */
public class ItemBuoyantBlock extends ItemBlock {
    public ItemBuoyantBlock(Block b) {
        super(b);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack is, World w, EntityPlayer p) {
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
                    net.minecraftforge.common.util.BlockSnapshot blocksnapshot = net.minecraftforge.common.util.BlockSnapshot.getBlockSnapshot(w, i, j + 1, k);
                    w.setBlock(i, j + 1, k, this.field_150939_a);
                    if (net.minecraftforge.event.ForgeEventFactory.onPlayerBlockPlace(p, blocksnapshot, net.minecraftforge.common.util.ForgeDirection.UP).isCanceled()) {
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
