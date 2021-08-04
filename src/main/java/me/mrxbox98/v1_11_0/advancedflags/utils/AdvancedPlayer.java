package me.mrxbox98.v1_11_0.advancedflags.utils;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class AdvancedPlayer {

    public static ArrayList<AdvancedPlayer> advancedPlayers = new ArrayList<>();

    public UUID uuid;

    public Player player;

    public int flagId=-1;

    public AdvancedPlayer(Player player)
    {
        this.player=player;
        this.uuid=player.getUniqueId();
    }

    public static AdvancedPlayer getAdvancedPlayer(Player player)
    {
        for(AdvancedPlayer advancedPlayer: advancedPlayers)
        {
            if(advancedPlayer.uuid.equals(player.getUniqueId()))
            {
                return advancedPlayer;
            }
        }
        return null;
    }

}
