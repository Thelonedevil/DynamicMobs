package com.github.thelonedevil.DynamicMobs;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by justin on 14/08/2014.
 */
public class ConfigurationHandler {
    public static Configuration configuration;
    public static boolean difficulty = false;
    public static int creeperxp= 12;
    public static int zombiexp = 6;
    public static int skelexp = 9;
    public static void init(File configFile)
    {
// Create the configuration object from the given configuration file
        if (configuration == null)
        {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }
    private static void loadConfiguration()
    {
        difficulty = configuration.getBoolean("difficulty", Configuration.CATEGORY_GENERAL, false, "Tie mob progression to the vanilla difficulty setting?");
        creeperxp = configuration.getInt("creeperXp",Configuration.CATEGORY_GENERAL, 12,0,Integer.MAX_VALUE,"This is the base xp that a level 1 creeper will give");
        zombiexp = configuration.getInt("zombieXp",Configuration.CATEGORY_GENERAL, 6,0,Integer.MAX_VALUE,"This is the base xp that a level 1 zombie will give");
        skelexp = configuration.getInt("skeleXp",Configuration.CATEGORY_GENERAL, 9,0,Integer.MAX_VALUE,"This is the base xp that a level 1 skeleton will give");
        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }
    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(Ref.MODID))
        {
            loadConfiguration();
        }
    }
}
