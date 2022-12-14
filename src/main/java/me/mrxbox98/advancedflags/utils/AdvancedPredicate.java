package me.mrxbox98.advancedflags.utils;

import com.github.fierioziy.particlenativeapi.api.utils.PlayerPredicate;
import org.bukkit.entity.Player;

public class AdvancedPredicate implements PlayerPredicate {

    /**
     * Returns true if a packet should be sent to a player.
     *
     * @param player a Player being processed by this predicate.
     * @return true if a packet should be sent to a player, false otherwise.
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
