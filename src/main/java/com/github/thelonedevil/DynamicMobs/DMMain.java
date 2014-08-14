package com.github.thelonedevil.DynamicMobs;

import com.github.thelonedevil.DynamicMobs.Event.FMLHandler;
import com.github.thelonedevil.DynamicMobs.Event.ForgeHandler;
import com.github.thelonedevil.DynamicMobs.proxy.CommonProxy;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by justin on 14/08/2014.
 */
@Mod(modid= Ref.MODID, name= Ref.NAME, version = Ref.VERSION, guiFactory = "com.github.thelonedevil.DynamicMobs.GuiFactory" )
public class DMMain {
    @Mod.Instance(Ref.MODID)
    public static DMMain instance;
    @SidedProxy(clientSide = "com.github.thelonedevil.DynamicMobs.proxy.ClientProxy", serverSide = "com.github.thelonedevil.DynamicMobs.proxy.CommonProxy")
    public static CommonProxy proxy;
    public static SimpleNetworkWrapper network;

    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        network = NetworkRegistry.INSTANCE.newSimpleChannel("DynamicMobs");
        network.registerMessage(SyncEEP.Handler.class, SyncEEP.class, 0 , Side.CLIENT);
        FMLCommonHandler.instance().bus().register(new FMLHandler());
        MinecraftForge.EVENT_BUS.register(new ForgeHandler());
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
    }

    @EventHandler
    public static void load(FMLInitializationEvent event) {

    }

    @EventHandler
    public static void post(FMLPostInitializationEvent event) {

    }
}
