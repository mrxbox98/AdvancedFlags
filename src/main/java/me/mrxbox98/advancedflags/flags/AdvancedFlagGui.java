package me.mrxbox98.advancedflags.flags;

import me.mrxbox98.advancedflags.AdvancedFlags;
import me.mrxbox98.advancedflags.LogHelper;
import me.mrxbox98.advancedflags.config.AdvancedConfig;
import me.mrxbox98.advancedflags.utils.AdvancedPlayer;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.awt.*;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AdvancedFlagGui implements Listener, LogHelper {

    private final Inventory inventory;

    private final Player player;

    public int page;

    /**
     * Creates a new GUI
     * @param player the player to create the GUI for
     */
    public AdvancedFlagGui(Player player, int page) {

        this.player=player;
        // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
        inventory = Bukkit.createInventory(null, 54, "AdvancedFlags");

        this.page=page;

        initializeItems();

        openInventory(player);
        // Put the items into the inventory
    }

    /**
     * Adds the items to the menu
     */
    public void initializeItems()
    {
        int startIndex = 45*(page-1);

        for(int i=startIndex;i<startIndex+45;i++)
        {
            if(i< FlagManager.flags.size())
            {
                if(Material.getMaterial("LIME_STAINED_GLASS_PANE")==null || Material.getMaterial("RED_STAINED_GLASS_PANE")==null)
                {
                    if(player.hasPermission("flags."+ FlagManager.flags.get(i).abbr))
                    {
                        inventory.addItem(createGuiItem(Material.getMaterial("STAINED_GLASS_PANE"), ChatColor.GREEN+ChatColor.BOLD.toString()+generateDashes(FlagManager.flags.get(i)), 5,generateMeta(FlagManager.flags.get(i))));
                    }
                    else
                    {
                        inventory.addItem(createGuiItem(Material.getMaterial("STAINED_GLASS_PANE"), ChatColor.RED+ChatColor.BOLD.toString()+"Flag " + AdvancedFlags.aliases.get(FlagManager.flags.get(i).abbr), 14,ChatColor.BOLD+ChatColor.WHITE.toString()+"---------------------------", ChatColor.AQUA+"You do not have this flag",ChatColor.BOLD+ChatColor.WHITE.toString()+"---------------------------"));
                    }
                }
                else
                {
                    if(player.hasPermission("flags."+ FlagManager.flags.get(i).abbr))
                    {
                        inventory.addItem(createGuiItem(Material.getMaterial("LIME_STAINED_GLASS_PANE"), ChatColor.GREEN+ChatColor.BOLD.toString()+"Flag " + AdvancedFlags.aliases.get(FlagManager.flags.get(i).abbr),generateMeta(FlagManager.flags.get(i))));
                    }
                    else
                    {
                        inventory.addItem(createGuiItem(Material.getMaterial("RED_STAINED_GLASS_PANE"), ChatColor.RED+ChatColor.BOLD.toString()+"Flag " + AdvancedFlags.aliases.get(FlagManager.flags.get(i).abbr), 14,ChatColor.BOLD+ChatColor.WHITE.toString()+"---------------------------", ChatColor.AQUA+"You do not have this flag",ChatColor.BOLD+ChatColor.WHITE.toString()+"---------------------------"));
                    }
                }



            }

        }
        inventory.setItem(45, createGuiItem(Material.ARROW,ChatColor.AQUA+"Previous Page",ChatColor.AQUA+"Click on this for the previous page"));
        inventory.setItem(53, createGuiItem(Material.ARROW,ChatColor.AQUA+"Next Page",ChatColor.AQUA+"Click on this for the next page"));
    }

    /**
     * Clears all items in the inventory
     */
    public void clearItems()
    {
        inventory.clear();
    }

    /**
     * Creates a new gui item
     * @param material the material to use
     * @param name the name of the item
     * @param lore the lore of the item
     * @return the item that was created
     */
    protected ItemStack createGuiItem(final Material material, final String name, final String... lore) {

        final ItemStack item = new ItemStack(material, 1);

        final ItemMeta meta = item.getItemMeta();

        // Set the name of the item
        meta.setDisplayName(name);

        // Set the lore of the item
        meta.setLore(Arrays.asList(lore));

        if(AdvancedConfig.glowingFlag)
        {
            meta.addEnchant(Enchantment.LUCK,-1,true);
        }

        item.setItemMeta(meta);

        return item;
    }

    /**
     * Creates a new GUI item with a color
     * @param material the material to use
     * @param name the name of the item
     * @param color the color to use
     * @param lore the lore of the item
     * @return the itemStack of the item
     */
    protected ItemStack createGuiItem(final Material material, final String name, int color, final String... lore) {

        final ItemStack item = new ItemStack(material, 1, (byte)color);

        final ItemMeta meta = item.getItemMeta();

        // Set the name of the item
        meta.setDisplayName(name);

        // Set the lore of the item
        meta.setLore(Arrays.asList(lore));

        if(AdvancedConfig.glowingFlag)
        {
            meta.addEnchant(Enchantment.LUCK,-1,true);
        }

        item.setItemMeta(meta);

        return item;
    }

    /**
     * Opens the inventory to the player
     * @param ent opens the inventory
     */
    public void openInventory(final HumanEntity ent) {
        ent.openInventory(inventory);
    }

    /**
     * Called when there is an inventory click
     * @param e the event
     */
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
        if (!e.getInventory().equals(inventory)) return;

        e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();

        if(clickedItem.getType()==null || clickedItem.getType()==Material.AIR)
        {
            return;
        }

        if(clickedItem.getType()==Material.ARROW)
        {
            if(clickedItem.getItemMeta().getDisplayName().contains("Previous Page"))
            {
                if(page>1)
                {
                    clearItems();
                    page--;
                    initializeItems();
                }
            }
            if(clickedItem.getItemMeta().getDisplayName().contains("Next Page"))
            {
                if(page<5)
                {
                    clearItems();
                    page++;
                    initializeItems();
                }
            }
            return;
        }




        final Player p = (Player) e.getWhoClicked();

        // Using slots click is a best option for your inventory click's
        if(AdvancedPlayer.getAdvancedPlayer(p).flagId==e.getRawSlot()+(page-1)*45)
        {
            AdvancedPlayer.getAdvancedPlayer(p).flagId=-1;
            LogHelper.send(p, "Removed your current flag.");
        }
        else
        {
            AdvancedPlayer.getAdvancedPlayer(p).flagId=e.getRawSlot()+(page-1)*45;
            LogHelper.send(p,"Equiped flag id: " +(e.getRawSlot()+(page-1)*45));
        }



    }

    // Cancel dragging in our inventory
    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if (e.getInventory().equals(inventory)) {
            e.setCancelled(true);
        }
    }

    /**
     * Generates meta on all versions using reflection
     * @param flag the flag to use
     * @return the meta
     */
    public String[] generateMeta(Flag flag)
    {
        if(!AdvancedConfig.flagPreview)
        {
            String[] strings = new String[3];
            strings[0]=ChatColor.BOLD+ChatColor.WHITE.toString()+"---------------------------";
            strings[1]= ChatColor.AQUA+"Click to select this flag to display";
            strings[2]=ChatColor.BOLD+ChatColor.WHITE.toString()+"---------------------------";
            return strings;
        }

        String[] strings = new String[flag.particles[0].length];

        try
        {
            Class cls = Class.forName("net.md_5.bungee.api.ChatColor");

            Method method = cls.getMethod("of", Color.class);



            for(int y=0;y<strings.length;y++)
            {
                strings[y]+=ChatColor.RESET+ChatColor.BOLD.toString()+"|";
                for(int x=0;x<flag.particles.length;x++)
                {
                    Object obj = method.invoke(this,flag.particles[x][y].color);
                    ChatColor chatColor = (ChatColor)obj;
                    strings[y]+=chatColor + ChatColor.BOLD.toString() +"█";
                }
                if(strings[y].contains("null"))
                {
                    strings[y]=strings[y].substring(0,strings[y].indexOf("null"))+strings[y].substring(strings[y].indexOf("null")+4);
                }
                strings[y]+=ChatColor.RESET+ChatColor.BOLD.toString()+ ChatColor.WHITE +"|";
            }
            return strings;
        }
        catch(Exception | Error e)
        {
            return new String[]{"MASSIVE PROBLEM REPORT ON GITHUB"};
        }
    }

    public String generateDashes(Flag flag)
    {
        String str = "";
        for(int i=0;i<flag.ow;i++)
        {
            str+="-";
            if(i*2== flag.ow)
            {
                str+=AdvancedFlags.aliases.get(flag.abbr.toUpperCase());
            }
        }
        return str;
    }


}
