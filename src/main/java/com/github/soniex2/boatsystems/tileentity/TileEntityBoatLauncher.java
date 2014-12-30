package com.github.soniex2.boatsystems.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/**
 * @author soniex2
 */
public class TileEntityBoatLauncher extends TileEntity {
    // NBT tag names
    private static final String TAG_FORCE = "Vertical velocity";
    private static final String TAG_SPEED = "Horizontal velocity";

    private double force = 2.; // Y
    private double speed = 3.; // X and Z

    public double getForce() {
        return force;
    }

    public void setForce(double force) {
        this.force = force;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public void readFromNBT(NBTTagCompound c) {
        // NBT tags can contain spaces
        setForce(c.getDouble(TAG_FORCE));
        setSpeed(c.getDouble(TAG_SPEED));
    }

    @Override
    public void writeToNBT(NBTTagCompound c) {
        // NBT tags can contain spaces
        c.setDouble(TAG_FORCE, getForce());
        c.setDouble(TAG_SPEED, getSpeed());
    }
}
