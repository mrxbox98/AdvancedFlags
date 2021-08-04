package me.mrxbox98.v1_9_1.advancedflags.config;

import me.mrxbox98.v1_9_1.advancedflags.AdvancedFlags;

public class AdvancedConfig {

    public static int delay = 2;

    public static boolean glowingFlag = false;

    public static void setupConfig()
    {
        AdvancedFlags.getInstance().getConfig().addDefault("Delay",2);
        AdvancedFlags.getInstance().getConfig().addDefault("GlowingFlag",false);
        AdvancedFlags.getInstance().saveDefaultConfig();
    }

}
