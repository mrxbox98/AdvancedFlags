package me.mrxbox98.advancedflags.utils;

import org.bukkit.entity.Player;

import java.util.function.Predicate;

public class AdvancedPredicate implements Predicate<Player> {

    /**
     * Returns true if a packet should be sent to a player.
     *
     * @param player a Player being processed by this predicate.
     * @return true if a packet should be sent to a player, false otherwise.
     */
    @Override
    public boolean test(Player player) {
        for(AdvancedPlayer advancedPlayer: AdvancedPlayer.advancedPlayers)
        {
            if(advancedPlayer.player.equals(player))
            {
                return !advancedPlayer.hidden;
            }
        }
        return false;
    }
}
