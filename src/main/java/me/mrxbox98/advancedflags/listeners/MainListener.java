package me.mrxbox98.advancedflags.listeners;

import me.mrxbox98.advancedflags.LogHelper;
import me.mrxbox98.advancedflags.config.AdvancedConfig;
import me.mrxbox98.advancedflags.flags.FlagManager;
import me.mrxbox98.advancedflags.utils.AdvancedPlayer;
import me.mrxbox98.advancedflags.utils.IpHelper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class MainListener implements Listener {

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event)
    {
        AdvancedPlayer.advancedPlayers.add(new AdvancedPlayer(event.getPlayer()));
        LogHelper.debug("Added player " + event.getPlayer().getDisplayName() + " to AdvancedPlayers");
        if(AdvancedConfig.locationFlag)
        {
            String ip = event.getPlayer().getAddress().getHostString();
            String country = IpHelper.getTwoLetterCode(ip);
            AdvancedPlayer.getAdvancedPlayer(event.getPlayer()).flagId=FlagManager.abbreviations.indexOf(country);
            if(FlagManager.abbreviations.indexOf(country)==-1)
            {
                LogHelper.debug("There was an error: report on GitHub with this info" + "\n" + country);
            }
        }
    }

    @EventHandler
    public void onPlayerKickEvent(PlayerKickEvent event)
    {
        AdvancedPlayer.advancedPlayers.remove(AdvancedPlayer.getAdvancedPlayer(event.getPlayer()));
        LogHelper.debug("Removed player " + event.getPlayer().getDisplayName() + " to AdvancedPlayers");
    }

    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent event)
    {
        AdvancedPlayer.advancedPlayers.remove(AdvancedPlayer.getAdvancedPlayer(event.getPlayer()));
        LogHelper.debug("Removed player " + event.getPlayer().getDisplayName() + " to AdvancedPlayers");
    }

}
