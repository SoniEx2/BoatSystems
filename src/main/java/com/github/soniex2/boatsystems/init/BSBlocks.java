package com.github.soniex2.boatsystems.init;

import com.github.soniex2.boatsystems.BoatSystems;
import com.github.soniex2.boatsystems.block.BlockBoatLauncher;
import com.github.soniex2.boatsystems.tileentity.TileEntityBoatLauncher;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraft.block.Block;

/**
 * @author soniex2
 */
@ObjectHolder(BoatSystems.MODID)
public class BSBlocks {
    public static Block boat_launcher = new BlockBoatLauncher();

    public static void init() {
        GameRegistry.registerBlock(boat_launcher, "boat_launcher");
        GameRegistry.registerTileEntity(TileEntityBoatLauncher.class, "TileEntityBoatLauncher");
    }
}
