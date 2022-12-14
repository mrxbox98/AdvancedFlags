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
     * Sets up the commands
     */
    public static void setupCommands()
    {
        AdvancedFlags.getInstance().getCommand("af").setExecutor(new AdvancedExecutor());
    }

}
