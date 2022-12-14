package me.mrxbox98.advancedflags.commands;

import me.mrxbox98.advancedflags.AdvancedFlags;
import me.mrxbox98.advancedflags.LogHelper;
import me.mrxbox98.advancedflags.flags.AdvancedFlagGui;
import me.mrxbox98.advancedflags.flags.FlagManager;
import me.mrxbox98.advancedflags.utils.AdvancedPlayer;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements LogHelper {

    /**
     * The help message
     */
    public static String helpMessage = ChatColor.AQUA.toString()+ ChatColor.BOLD +"AdvancedFlags Version: " + AdvancedFlags.version + "\n"+
            "/af help - "+ChatColor.WHITE+"Main AdvancedCosmetics help command\n"+
            ChatColor.BOLD +ChatColor.AQUA+"/af flags - "+ChatColor.WHITE+"Select your flag\n"+
            ChatColor.BOLD +ChatColor.AQUA+"/af rotate - "+ChatColor.WHITE+"Change flags every second\n"+
            ChatColor.BOLD +ChatColor.AQUA+"/af version - "+ChatColor.WHITE+"Check AdvancedFlags version\n"+
            ChatColor.BOLD +ChatColor.AQUA+"/af none - "+ChatColor.WHITE+"Removes your current flag";


    /**
     * Sets up the commands
     */
    public static void setupCommands()
    {
        AdvancedFlags.getInstance().getCommand("af").setExecutor(new AdvancedExecutor());
    }

}
