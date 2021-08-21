package me.mrxbox98.advancedflags.config;

import me.mrxbox98.advancedflags.AdvancedFlags;
import org.bukkit.configuration.file.FileConfiguration;

public class AdvancedConfig {

    public static int delay = 2;

    public static boolean glowingFlag = false;

    public static double heightFromPlayer = 4d;

    public static boolean animate = false;

    public static double renderDistance = 30.0d;

    public static boolean locationFlag = false;

    public static String ipStackApiKey = "";

    public static boolean debug=false;

    public static boolean flagPreview=false;

    public static boolean rotateYaw=false;

    public static boolean rotatePitch=false;

    public static void setupConfig()
    {
        FileConfiguration config = AdvancedFlags.getInstance().getConfig();

        if(!config.contains("Delay"))
        {
            config.addDefault("Delay",2);
        }

        if(!config.contains("GlowingFlag"))
        {
            config.addDefault("GlowingFlag",false);
        }

        if(!config.contains("HeightFromPlayer"))
        {
            config.addDefault("HeightFromPlayer",4d);
        }

        if(!config.contains("Animate"))
        {
            config.addDefault("Animate",false);
        }

        if(!config.contains("RenderDistance"))
        {
            config.addDefault("RenderDistance",30D);
        }

        if(!config.contains("LocationFlag"))
        {
            config.addDefault("LocationFlag",false);
        }

        if(!config.contains("IpStackApiKey"))
        {
            config.addDefault("IpStackApiKey","");
        }

        if(!config.contains("Debug"))
        {
            config.addDefault("Debug",false);
        }

        if(!config.contains("FlagPreview"))
        {
            config.addDefault("FlagPreview",false);
        }

        if(!config.contains("RotateYaw"))
        {
            config.addDefault("RotateYaw",false);
        }

        if(!config.contains("RotatePitch"))
        {
            config.addDefault("RotatePitch",false);
        }

        config.options().copyDefaults(true);
        AdvancedFlags.getInstance().saveConfig();

        delay=config.getInt("Delay");
        glowingFlag=config.getBoolean("GlowingFlag");
        heightFromPlayer=config.getDouble("HeightFromPlayer");
        animate=config.getBoolean("Animate");
        renderDistance=config.getDouble("RenderDistance");
        locationFlag=config.getBoolean("LocationFlag");
        ipStackApiKey=config.getString("IpStackApiKey");
        debug=config.getBoolean("Default");
        flagPreview=config.getBoolean("FlagPreview");
        rotateYaw=config.getBoolean("RotateYaw");
        rotatePitch=config.getBoolean("RotatePitch");
    }

}
