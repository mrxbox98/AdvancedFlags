package me.mrxbox98.advancedflags.config;

import me.mrxbox98.advancedflags.AdvancedFlags;

public class AdvancedConfig {

    public static int delay = 2;

    public static boolean glowingFlag = false;

    public static double heightFromPlayer = 4d;

    public static boolean animate = false;

    public static void setupConfig()
    {
        if(!AdvancedFlags.getInstance().getConfig().contains("Delay"))
        {
            AdvancedFlags.getInstance().getConfig().addDefault("Delay",2);
        }

        if(!AdvancedFlags.getInstance().getConfig().contains("GlowingFlag"))
        {
            AdvancedFlags.getInstance().getConfig().addDefault("GlowingFlag",false);
        }

        if(!AdvancedFlags.getInstance().getConfig().contains("HeightFromPlayer"))
        {
            AdvancedFlags.getInstance().getConfig().addDefault("HeightFromPlayer",4d);
        }

        if(!AdvancedFlags.getInstance().getConfig().contains("Animate"))
        {
            AdvancedFlags.getInstance().getConfig().addDefault("Animate",false);
        }

        AdvancedFlags.getInstance().getConfig().options().copyDefaults(true);
        AdvancedFlags.getInstance().saveConfig();

        delay=AdvancedFlags.getInstance().getConfig().getInt("Delay");
        glowingFlag=AdvancedFlags.getInstance().getConfig().getBoolean("GlowingFlag");
        heightFromPlayer=AdvancedFlags.getInstance().getConfig().getDouble("HeightFromPlayer");
        animate=AdvancedFlags.getInstance().getConfig().getBoolean("Animate");
    }

}
