package me.mrxbox98.advancedflags;

import org.bukkit.plugin.java.JavaPlugin;

public final class AdvancedFlags extends JavaPlugin implements LogHelper {

    public static JavaPlugin instance;

    @Override
    public void onEnable() {
        System.out.println(getServer().getVersion());

        if(getServer().getVersion().contains("1.8.8"))
        {
            instance=new me.mrxbox98.v1_8_8.advancedflags.AdvancedFlags();
            instance.onEnable();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
