package com.github.soniex2.boatsystems.init;

import com.github.soniex2.boatsystems.BoatSystems;
import cpw.mods.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

/**
 * @author soniex2
 */
@ObjectHolder(BoatSystems.MODID)
public class BSItems {
    public static Item buoyant_redstone;

    public static void init() {
        buoyant_redstone = Items.redstone; // TODO
    }
}
