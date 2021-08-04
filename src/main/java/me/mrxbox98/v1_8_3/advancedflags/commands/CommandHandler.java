package me.mrxbox98.v1_8_3.advancedflags.commands;

import me.mrxbox98.v1_8_3.advancedflags.AdvancedFlags;
import me.mrxbox98.v1_8_3.advancedflags.flags.AdvancedFlagGui;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler {

    /**
     * The help message
     */
    public static String helpMessage = ChatColor.AQUA.toString()+ ChatColor.BOLD +"AdvancedFlags Version:1.0.0\n"+
            "/af help - "+ChatColor.WHITE+"Main AdvancedCosmetics help command\n"+
            ChatColor.AQUA+"/af flags = "+ChatColor.WHITE+"Select your flag";


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
                if(strings[0].equalsIgnoreCase("flags"))
                {
                    AdvancedFlags.getInstance().getServer().getPluginManager().registerEvents(new AdvancedFlagGui((Player) commandSender,1), AdvancedFlags.getInstance());
                }

                return true;
            }
        });
    }

}
