package me.mrxbox98.advancedflags.commands;

import me.mrxbox98.advancedflags.AdvancedFlags;
import me.mrxbox98.advancedflags.LogHelper;
import me.mrxbox98.advancedflags.flags.AdvancedFlagGui;
import me.mrxbox98.advancedflags.flags.FlagManager;
import me.mrxbox98.advancedflags.utils.AdvancedPlayer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements LogHelper {

    /**
     * The help message
     */
    public static String helpMessage = ChatColor.AQUA.toString()+ ChatColor.BOLD +"AdvancedFlags Version:1.0.0\n"+
            "/af help - "+ChatColor.WHITE+"Main AdvancedCosmetics help command\n"+
            ChatColor.BOLD.toString()+ChatColor.AQUA+"/af flags - "+ChatColor.WHITE+"Select your flag";


    /**
     * GUIDE ON HOW TO CREATE A COMMAND
     *
     * 1. Create a new if statement first checking for
     * strings.length to prevent a ArrayOutOfBounds Exception
     * and then checking the command name
     *
     * 2. Inside the if statement run all code and make it
     * async if possible
     *
     * 3. At the end of the if statement make sure to return true;
     */
    public static void setupCommands()
    {
        /*
         * <br>The command for all AdvancedCosmetics Commands<br>
         */
        AdvancedFlags.getInstance().getCommand("af").setExecutor(new CommandExecutor() {
            /**
             * Used for all commands<br>
             * @param commandSender the player that sent the command<br>
             * @param command the command that was sent in plugin.yml<br>
             * @param s I do not know what this is<br>
             * @param strings the parameters of the command<br>
             * @return true or false does not matter<br>
             */
            @Override
            public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

                /*
                 * <br>Ends the piece of code if the commandSender
                 * is not a player on the server<br>
                 */
                if(!(commandSender instanceof Player))
                {
                    commandSender.sendMessage("You need to be a player to use this command!");
                    return true;
                }

                //Casts the command sender to a player as it is always a player
                Player player = ((Player) commandSender);

                /*
                 * <br>Sends the help message to the player
                 * if there are no args or the first arg
                 * is help<br>
                 */
                if(strings.length==0 || strings[0].equalsIgnoreCase("help"))
                {
                    commandSender.sendMessage(helpMessage);
                    return true;
                }

                /*
                 * <br>Opens the Flag Gui with the player<br>
                 * <br>Also prevents any error and checks args<br>
                 */
                if(strings[0].equalsIgnoreCase("flags") && strings.length==1)
                {
                    AdvancedFlags.getInstance().getServer().getPluginManager().registerEvents(new AdvancedFlagGui((Player) commandSender,1), AdvancedFlags.getInstance());
                    return true;
                }

                /*
                 * The player will be able to select their own flag with a two digit code or the name
                 */
                if(strings[0].equalsIgnoreCase("flags") && strings.length==2)
                {

                    if(strings[1].length()==2)
                    {
                        AdvancedPlayer.getAdvancedPlayer(player).flagId= FlagManager.abbreviations.indexOf(strings[1].toUpperCase());
                    }
                    else
                    {
                        AdvancedFlags.aliases.forEach((k,v) -> {
                            if(v.equalsIgnoreCase(strings[1]))
                            {
                                AdvancedPlayer.getAdvancedPlayer(player).flagId= FlagManager.abbreviations.indexOf(k.toLowerCase());
                            }
                        });
                    }
                    return true;
                }

                if(strings[0].equalsIgnoreCase("version"))
                {
                    LogHelper.send(player,"This server is running AdvancedFlags version " + AdvancedFlags.version);
                    return true;
                }

                if(strings[0].equalsIgnoreCase("rotate"))
                {
                    if(player.hasPermission("flags.rotate"))
                    {
                        AdvancedPlayer.getAdvancedPlayer(player).rotate=!AdvancedPlayer.getAdvancedPlayer(player).rotate;
                    }
                    return true;
                }

                if(strings[0].equalsIgnoreCase("hide"))
                {
                    AdvancedPlayer.getAdvancedPlayer(player).hidden=!AdvancedPlayer.getAdvancedPlayer(player).hidden;
                    return true;
                }


                return true;
            }
        });
    }

}
