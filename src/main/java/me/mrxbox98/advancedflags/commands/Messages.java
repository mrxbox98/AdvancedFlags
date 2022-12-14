package me.mrxbox98.advancedflags.commands;

import me.mrxbox98.advancedflags.AdvancedFlags;
import net.md_5.bungee.api.ChatColor;

public class Messages {
    
    public static final String HELP_MESSAGE = ChatColor.AQUA.toString()+ ChatColor.BOLD +"AdvancedFlags Version: " + AdvancedFlags.PLUGIN_VERSION + "\n"+
            "/af help - "+ChatColor.WHITE+"Main AdvancedCosmetics help command\n"+
            ChatColor.BOLD +ChatColor.AQUA+"/af flags - "+ChatColor.WHITE+"Select your flag\n"+
            ChatColor.BOLD +ChatColor.AQUA+"/af rotate - "+ChatColor.WHITE+"Change flags every second\n"+
            ChatColor.BOLD +ChatColor.AQUA+"/af version - "+ChatColor.WHITE+"Check AdvancedFlags version\n"+
            ChatColor.BOLD +ChatColor.AQUA+"/af none - "+ChatColor.WHITE+"Removes your current flag";
    
}
