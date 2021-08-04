package me.mrxbox98.advancedflags;

import org.bukkit.plugin.java.JavaPlugin;

public final class AdvancedFlags extends JavaPlugin implements LogHelper {

    @Override
    public void onEnable() {
        System.out.println(getServer().getVersion());

        if(getServer().getVersion().contains("1.8.8"))
        {
            getServer().getPluginManager().disablePlugin(this);
            getServer().getPluginManager().enablePlugin(new me.mrxbox98.v1_8_8.advancedflags.AdvancedFlags());
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
