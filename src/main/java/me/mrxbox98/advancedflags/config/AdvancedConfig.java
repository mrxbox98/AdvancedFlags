package me.mrxbox98.advancedflags.config;

import me.mrxbox98.advancedflags.AdvancedFlags;

public class AdvancedConfig {

    public static int delay = 2;

    public static boolean glowingFlag = false;

    public static double heightFromPlayer = 4d;

    public static void setupConfig()
    {
        AdvancedFlags.getInstance().getConfig().addDefault("Delay",2);
        AdvancedFlags.getInstance().getConfig().addDefault("GlowingFlag",false);
        AdvancedFlags.getInstance().getConfig().addDefault("HeightFromPlayer",4d);
        AdvancedFlags.getInstance().saveDefaultConfig();

        delay=AdvancedFlags.getInstance().getConfig().getInt("Delay");
        glowingFlag=AdvancedFlags.getInstance().getConfig().getBoolean("GlowingFlag");
        heightFromPlayer=AdvancedFlags.getInstance().getConfig().getDouble("HeightFromPlayer");
    }

}
