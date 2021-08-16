package me.mrxbox98.advancedflags.utils;

import com.github.fierioziy.particlenativeapi.api.utils.PlayerPredicate;
import org.bukkit.entity.Player;

public class AdvancedPredicate implements PlayerPredicate {

    /**
     * Returns <code>true</code> if a packet should be send to a player.
     *
     * @param player a <code>Player</code> being processed by this predicate.
     * @return <code>true</code> if a packet should be send to a player, <code>false</code> otherwise.
     */
    @Override
    public boolean shouldSend(Player player) {
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
