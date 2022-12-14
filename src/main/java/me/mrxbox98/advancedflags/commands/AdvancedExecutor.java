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

import java.util.Arrays;

public class AdvancedExecutor implements CommandExecutor {

    /**
     * Runs a command
     * @param sender Source of the command
     * @param command Command which was executed
     * @param label Alias of the command which was used
     * @param args Passed command arguments
     * @return true
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        /*
         * Ends the piece of code if the commandSender
         * is not a player on the server
         */
        if(!(sender instanceof Player))
        {
            sender.sendMessage("You need to be a player to use this command!");
            return true;
        }

        Player player = ((Player) sender);

        if(args.length==0) {
            helpMessage(player);
            return true;
        }
        
        switch (args[0].toLowerCase()) {
            case "help": {
                helpMessage(player);
                return true;
            }
            case "flags": {
                flag(player, Arrays.copyOfRange(args, 1, args.length));
                return true;
            }
            case "version": {
                sendVersion(player);
                return true;
            }
            case "hide": {
                hide(player);
                return true;
            }
            case "rotate": {
                rotate(player);
                return true;
            }
            case "none": {
                none(player);
                return true;
            }
            default: {
                player.sendMessage(ChatColor.RED+"This AdvancedFlag command is not recognized!");
                return true;
            }
        }
    }

    /**
     * Sends the player the help message
     * @param player the player to send the help message to
     */
    public void helpMessage(Player player) {
        player.sendMessage(Messages.HELP_MESSAGE);
    }

    /**
     * Sends the plugin version to the player
     * @param player the player
     */
    public void sendVersion(Player player) {
        LogHelper.send(player,"This server is running AdvancedFlags version " + AdvancedFlags.PLUGIN_VERSION);
    }

    /**
     * Hides flags from the players view
     * @param player the player
     */
    public void hide(Player player) {
        AdvancedPlayer.getAdvancedPlayer(player).hidden=!AdvancedPlayer.getAdvancedPlayer(player).hidden;
        if(AdvancedPlayer.getAdvancedPlayer(player).hidden)
        {
            LogHelper.send(player,"You will now not see flags.");
        }
        else
        {
            LogHelper.send(player,"You will now see flags.");
        }
    }

    /**
     * Rotates the flags
     * @param player the player
     */
    public void rotate(Player player) {
        if(player.hasPermission("flags.rotate"))
        {
            AdvancedPlayer.getAdvancedPlayer(player).rotate=!AdvancedPlayer.getAdvancedPlayer(player).rotate;
            LogHelper.send(player,"Flags will now automatically change.");
        }
        else
        {
            LogHelper.send(player,"You do not have the permissions for this command.");
        }
    }

    /**
     * Sets the flag for the player
     * @param player the player
     * @param args the command args
     */
    public void flag(Player player, String[] args) {
        if(args.length==0)
        {
            AdvancedFlags.getInstance().getServer().getPluginManager().registerEvents(new AdvancedFlagGui(player,1), AdvancedFlags.getInstance());
        }
        else
        {
            if(args[0].length()==2)
            {
                AdvancedPlayer.getAdvancedPlayer(player).flagId= FlagManager.abbreviations.indexOf(args[0].toUpperCase());
            }
            else
            {
                AdvancedFlags.aliases.forEach((k,v) -> {
                    if(v.equalsIgnoreCase(args[0]))
                    {
                        AdvancedPlayer.getAdvancedPlayer(player).flagId= FlagManager.abbreviations.indexOf(k.toLowerCase());
                    }
                });
            }
        }
    }

    /**
     * Removes the flag
     * @param player the player
     */
    public void none(Player player) {
        AdvancedPlayer.getAdvancedPlayer(player).flagId=-1;
        LogHelper.send(player,"Removed your flag.");
    }
}
