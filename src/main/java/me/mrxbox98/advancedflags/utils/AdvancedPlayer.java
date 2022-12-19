package me.mrxbox98.advancedflags.utils;

import me.mrxbox98.advancedflags.flags.FlagManager;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class AdvancedPlayer {

    public static ArrayList<AdvancedPlayer> advancedPlayers = new ArrayList<>();

    public Player player;

    public boolean rotate = false;

    public int flagId = -1;
    
    public int scale = 1;

    public boolean hidden = false;

    public AdvancedPlayer(Player player)
    {
        this.player=player;
    }

    public static AdvancedPlayer getAdvancedPlayer(Player player)
    {
        for(AdvancedPlayer advancedPlayer: advancedPlayers)
        {
            if(advancedPlayer.player.equals(player))
            {
                return advancedPlayer;
            }
        }
        return null;
    }

    public void advance()
    {
        if(flagId< FlagManager.flags.size()-1)
        {
            flagId++;
        }
        else
        {
            flagId=0;
        }
    }

}
