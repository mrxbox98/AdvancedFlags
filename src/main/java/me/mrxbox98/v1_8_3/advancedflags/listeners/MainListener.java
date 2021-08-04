package me.mrxbox98.v1_8_3.advancedflags.listeners;

import me.mrxbox98.v1_8_3.advancedflags.utils.AdvancedPlayer;
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
