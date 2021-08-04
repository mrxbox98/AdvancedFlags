package me.mrxbox98.v1_9_4.advancedflags;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public interface LogHelper {

    /**
     * Resets console text formatting
     */
    String RESET = "\u001B[0m";

    /**
     * Black console text formatting
     */
    String BLACK = "\u001B[30m";

    /**
     * Red console text formatting
     */
    String RED = "\u001B[31m";

    /**
     * Green console text formatting
     */
    String GREEN = "\u001B[32m";

    /**
     * Yellow console text formatting
     */
    String YELLOW = "\u001B[33m";
    String BLUE = "\u001B[34m";
    String PURPLE = "\u001B[35m";
    String CYAN = "\u001B[36m";
    String WHITE = "\u001B[37m";

    String BLACK_BACKGROUND = "\u001B[40m";
    String RED_BACKGROUND = "\u001B[41m";
    String GREEN_BACKGROUND = "\u001B[42m";
    String YELLOW_BACKGROUND = "\u001B[43m";
    String BLUE_BACKGROUND = "\u001B[44m";
    String PURPLE_BACKGROUND = "\u001B[45m";
    String CYAN_BACKGROUND = "\u001B[46m";
    String WHITE_BACKGROUND = "\u001B[47m";

    default void log(String toLog)
    {
        System.out.println(CYAN+"ADVANCEDFLAGS>>");
    }

    /**
     * Sends a formatted String to the player
     * @param player the player to send it to
     * @param str string to send
     */
    default void send(Player player, String str)
    {
        player.sendMessage(ChatColor.AQUA.toString()+ChatColor.BOLD+"AdvancedFlags>>"+ChatColor.RESET+str);
    }

}
