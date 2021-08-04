package me.mrxbox98.advancedflags;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class AdvancedFlags extends JavaPlugin implements LogHelper {

    public static JavaPlugin instance;

    @Override
    public void onEnable() {
        instance=this;

        System.out.println(getServer().getVersion());

        if(getServer().getVersion().contains("1.8.8"))
        {
            new AdvancedFlags().onEnable();
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
