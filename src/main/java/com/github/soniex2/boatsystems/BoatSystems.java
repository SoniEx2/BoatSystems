package com.github.soniex2.boatsystems;

import com.github.soniex2.boatsystems.init.BSBlocks;
import com.github.soniex2.boatsystems.init.BSFluids;
import com.github.soniex2.boatsystems.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * @author soniex2
 */
@Mod(name = BoatSystems.MODNAME, modid = BoatSystems.MODID, version = BoatSystems.VERSION)
public class BoatSystems {
    /* Constants */
    public static final String MODNAME = "BoatSystems";
    public static final String MODID = "boatsystems";
    public static final String VERSION = "0.0.0";
    public static final String PKGBASE = "com.github.soniex2.boatsystems";
    public static final String PROXYBASE = PKGBASE + ".proxy";

    @Mod.Instance
    public static BoatSystems instance;

    @SidedProxy(clientSide = PROXYBASE + ".ClientProxy", serverSide = PROXYBASE + ".ServerProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        BSFluids.init();
        BSBlocks.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }
}
