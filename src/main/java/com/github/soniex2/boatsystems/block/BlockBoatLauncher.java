package com.github.soniex2.boatsystems.block;

import com.github.soniex2.boatsystems.WatTheHellJustHappenedException;
import com.github.soniex2.boatsystems.tileentity.TileEntityBoatLauncher;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

/**
 * @author soniex2
 */
public class BlockBoatLauncher extends BlockContainer {
    private static final float HEIGHT = 1f / 64f;

    public BlockBoatLauncher() {
        super(Material.circuits);
        this.setBlockBounds(0f, 0.0F, 0f, 1f, HEIGHT, 1f);
        this.setCreativeTab(CreativeTabs.tabTransport);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World w, int x, int y, int z) {
        return null;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public void onEntityCollidedWithBlock(World w, int x, int y, int z, Entity e) {
        if (e instanceof EntityBoat) {
            TileEntity te = w.getTileEntity(x, y, z);
            if (te instanceof TileEntityBoatLauncher) {
                // add vertical velocity
                e.addVelocity(0., ((TileEntityBoatLauncher) te).getForce(), 0.);
                double speed = ((TileEntityBoatLauncher) te).getSpeed();
                double angle = Math.toRadians(e.rotationYaw);
                // the angle above is wrong
                double sin = -Math.sin(angle);
                double cos = -Math.cos(angle);
                e.addVelocity(cos * speed, 0., sin * speed);
            } else {
                // easter egg? :P
                throw new WatTheHellJustHappenedException(String.format("Unexpected TileEntity %s for block at %d, %d, %d on world %s (dimension %d, %s)", te.getClass().getName(), x, y, z, w.getWorldInfo().getWorldName(), w.provider.dimensionId, w.provider.getDimensionName()));
            }
        }
    }

    @Override
    public TileEntity createNewTileEntity(World w, int m) {
        return new TileEntityBoatLauncher();
    }
}
