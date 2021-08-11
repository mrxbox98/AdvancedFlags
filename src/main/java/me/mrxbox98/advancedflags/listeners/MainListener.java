package me.mrxbox98.advancedflags.listeners;

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
        if(AdvancedConfig.locationFlag)
        {
            String ip = event.getPlayer().getAddress().getHostString();
            String country = IpHelper.getTwoLetterCode(ip);
            AdvancedPlayer.getAdvancedPlayer(event.getPlayer()).flagId=FlagManager.abbreviations.indexOf(country);
        }
    }

    @EventHandler
    public void onPlayerKickEvent(PlayerKickEvent event)
    {
        AdvancedPlayer.advancedPlayers.remove(AdvancedPlayer.getAdvancedPlayer(event.getPlayer()));
    }

    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent event)
    {
        AdvancedPlayer.advancedPlayers.remove(AdvancedPlayer.getAdvancedPlayer(event.getPlayer()));
    }

}
