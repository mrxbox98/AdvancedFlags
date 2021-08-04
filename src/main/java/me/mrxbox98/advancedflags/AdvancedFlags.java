package me.mrxbox98.advancedflags;

import org.bukkit.plugin.java.JavaPlugin;

public final class AdvancedFlags extends JavaPlugin implements LogHelper {

    public static JavaPlugin instance;

    @Override
    public void onEnable() {
        instance=this;

        System.out.println(getServer().getVersion());

        if(getServer().getVersion().contains("1.8.8"))
        {
            new me.mrxbox98.v1_8_8.advancedflags.AdvancedFlags().onEnable();
        }
    }

    @Override
    public void onDisable() {
    }

    public static JavaPlugin getInstance()
    {
        return instance;
    }

}
