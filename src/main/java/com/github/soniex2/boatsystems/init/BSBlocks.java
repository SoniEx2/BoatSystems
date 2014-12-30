package com.github.soniex2.boatsystems.init;

import com.github.soniex2.boatsystems.BoatSystems;
import com.github.soniex2.boatsystems.block.BlockBoatLauncher;
import com.github.soniex2.boatsystems.block.BlockBuoyantRedstoneRepeater;
import com.github.soniex2.boatsystems.block.BlockBuoyantRedstoneWire;
import com.github.soniex2.boatsystems.item.ItemBuoyantBlock;
import com.github.soniex2.boatsystems.tileentity.TileEntityBoatLauncher;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneDiode;

/**
 * @author soniex2
 */
@ObjectHolder(BoatSystems.MODID)
public class BSBlocks {
    public static Block boat_launcher;
    public static Block buoyant_redstone_wire;
    public static Block buoyant_unpowered_redstone_repeater;
    public static Block buoyant_powered_redstone_repeater;

    public static void init() {
        boat_launcher = GameRegistry.registerBlock(new BlockBoatLauncher(), ItemBuoyantBlock.class, "boat_launcher");
        GameRegistry.registerTileEntity(TileEntityBoatLauncher.class, "TileEntityBoatLauncher");
        buoyant_redstone_wire = GameRegistry.registerBlock(new BlockBuoyantRedstoneWire(), ItemBuoyantBlock.class, "buoyant_redstone_wire");
        buoyant_unpowered_redstone_repeater = GameRegistry.registerBlock(new BlockBuoyantRedstoneRepeater(false), ItemBuoyantBlock.class, "buoyant_unpowered_redstone_repeater");
        buoyant_powered_redstone_repeater = GameRegistry.registerBlock(new BlockBuoyantRedstoneRepeater(true), "buoyant_powered_redstone_repeater");
    }
}
