package com.github.thelonedevil.DynamicMobs.proxy;

import com.github.thelonedevil.DynamicMobs.DMMain;
import com.github.thelonedevil.DynamicMobs.network.SyncEEP;
import cpw.mods.fml.relauncher.Side;

/**
 * Created by justin on 14/08/2014.
 */
public class ClientProxy extends CommonProxy {
    @Override
    public void registerNetwork(){
        DMMain.network.registerMessage(SyncEEP.Handler.class, SyncEEP.class, 0 , Side.CLIENT);
    }
}
