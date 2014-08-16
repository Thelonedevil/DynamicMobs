package com.github.thelonedevil.DynamicMobs.client;

/**
 * Created by justin on 14/08/2014.
 */
import com.github.thelonedevil.DynamicMobs.handler.ConfigurationHandler;
import com.github.thelonedevil.DynamicMobs.utlitiy.Ref;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
public class ModGuiConfig extends GuiConfig
{
    public ModGuiConfig(GuiScreen guiScreen)
    {
        super(guiScreen,
                new ConfigElement(ConfigurationHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                Ref.MODID,
                false,
                false,
                GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString()));
    }
}
