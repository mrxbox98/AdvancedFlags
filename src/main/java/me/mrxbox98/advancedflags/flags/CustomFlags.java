package me.mrxbox98.advancedflags.flags;

import me.mrxbox98.advancedflags.AdvancedFlags;

import java.io.File;

public class CustomFlags {

    /**
     * Checks for all files in the plugins folder with a .png
     */
    public static void setupCustomFlags()
    {
        File data = AdvancedFlags.getInstance().getDataFolder();

        File[] files = data.listFiles();

        for(File file: files)
        {
            if(file.getName().endsWith(".png"))
            {
                loadResource(file);
            }
        }
    }

    /**
     * Adds the file to be setup
     * @param file the file
     */
    public static void loadResource(File file)
    {
        if(file.getName().substring(0,2).startsWith(".") || file.getName().substring(0,2).endsWith("."))
        {
            return;
        }

        FlagManager.abbreviations.add(file.getName().substring(0,2));
        AdvancedFlags.aliases.put(file.getName().substring(0,2),file.getName().substring(0,2));
    }

}
