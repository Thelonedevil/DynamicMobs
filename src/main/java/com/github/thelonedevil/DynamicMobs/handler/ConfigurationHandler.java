package com.github.thelonedevil.DynamicMobs.handler;

import com.github.thelonedevil.DynamicMobs.utlitiy.Ref;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by justin on 14/08/2014.
 */
public class ConfigurationHandler {
    public static Configuration configuration;
    public static boolean difficulty = false;
    public static int creeperxp = 12;
    public static int zombiexp = 6;
    public static int skelexp = 9;
    public static int witherSkelexp = 12;
    public static int pigZombiexp = 8;
    public static int slimexp = 4;
    public static int magmaCubexp = 5;
    public static int witchxp = 15;
    public static int spiderxp = 7;
    public static int caveSpiderxp = 14;
    public static int endermanxp = 20;
    public static int enderdragonxp = 400;
    public static int witherxp = 400;
    public static int ghastxp = 10;
    public static int blazexp = 10;
    public static int silverfishxp = 3;
    public static List<String> players;

    public static void init(File configFile) {
// Create the configuration object from the given configuration file
        if (configuration == null) {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    private static void loadConfiguration() {
        difficulty = configuration.getBoolean("difficulty", Configuration.CATEGORY_GENERAL, false, "Tie mob progression to the vanilla difficulty setting?");
        creeperxp = configuration.getInt("creeperXp", Configuration.CATEGORY_GENERAL, 12, 0, Integer.MAX_VALUE, "This is the base xp that a level 1 creeper will give");
        zombiexp = configuration.getInt("zombieXp", Configuration.CATEGORY_GENERAL, 6, 0, Integer.MAX_VALUE, "This is the base xp that a level 1 zombie will give");
        skelexp = configuration.getInt("skeleXp", Configuration.CATEGORY_GENERAL, 9, 0, Integer.MAX_VALUE, "This is the base xp that a level 1 skeleton will give");
        witherSkelexp = configuration.getInt("witherSkeleXp", Configuration.CATEGORY_GENERAL, 12, 0, Integer.MAX_VALUE, "This is the base xp that a level 1  wither skeleton will give");
        pigZombiexp = configuration.getInt("pigZombiwXp", Configuration.CATEGORY_GENERAL, 8, 0, Integer.MAX_VALUE, "This is the base xp that a level 1  wither skeleton will give");
        slimexp = configuration.getInt("slimeXp", Configuration.CATEGORY_GENERAL, 4, 0, Integer.MAX_VALUE, "This is the base xp that a level 1  wither skeleton will give");
        magmaCubexp = configuration.getInt("magmaCubeXp", Configuration.CATEGORY_GENERAL, 5, 0, Integer.MAX_VALUE, "This is the base xp that a level 1  wither skeleton will give");
        witchxp = configuration.getInt("witchXp", Configuration.CATEGORY_GENERAL, 15, 0, Integer.MAX_VALUE, "This is the base xp that a level 1  wither skeleton will give");
        spiderxp = configuration.getInt("spiderXp", Configuration.CATEGORY_GENERAL, 7, 0, Integer.MAX_VALUE, "This is the base xp that a level 1  wither skeleton will give");
        caveSpiderxp = configuration.getInt("caveSpiderXp", Configuration.CATEGORY_GENERAL, 14, 0, Integer.MAX_VALUE, "This is the base xp that a level 1  wither skeleton will give");
        endermanxp = configuration.getInt("endermanXp", Configuration.CATEGORY_GENERAL, 20, 0, Integer.MAX_VALUE, "This is the base xp that a level 1  wither skeleton will give");
        enderdragonxp = configuration.getInt("enderdragonXp", Configuration.CATEGORY_GENERAL, 400, 0, Integer.MAX_VALUE, "This is the base xp that a level 1  wither skeleton will give");
        witherxp = configuration.getInt("witherXp", Configuration.CATEGORY_GENERAL, 400, 0, Integer.MAX_VALUE, "This is the base xp that a level 1  wither skeleton will give");
        ghastxp = configuration.getInt("ghastXp", Configuration.CATEGORY_GENERAL, 10, 0, Integer.MAX_VALUE, "This is the base xp that a level 1  wither skeleton will give");
        blazexp = configuration.getInt("blazeXp", Configuration.CATEGORY_GENERAL, 10, 0, Integer.MAX_VALUE, "This is the base xp that a level 1  wither skeleton will give");
        silverfishxp = configuration.getInt("silverfishXp", Configuration.CATEGORY_GENERAL, 3, 0, Integer.MAX_VALUE, "This is the base xp that a level 1  wither skeleton will give");
        players = Arrays.asList(configuration.getStringList("players", Configuration.CATEGORY_GENERAL, new String[]{}, "List of players that are exempt from this mod"));
        if (configuration.hasChanged()) {
            configuration.save();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.modID.equalsIgnoreCase(Ref.MODID)) {
            loadConfiguration();
        }
    }
}
