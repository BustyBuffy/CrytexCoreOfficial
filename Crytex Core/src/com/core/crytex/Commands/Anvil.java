package com.core.crytex.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class Anvil implements CommandExecutor
{
	
	String title = ChatColor.AQUA + "[" + ChatColor.RED + "CrytexCore" + ChatColor.AQUA + "]";

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(!(sender instanceof Player)){
			sender.sendMessage("You can not use this command!");
		}
		Player p = (Player) sender;
	    if (!p.hasPermission("cc.anvil"))
	    {
	      p.sendMessage(this.title + ChatColor.RED + " You do not have permission!");
	      p.sendMessage(this.title + ChatColor.RED + " Donate for this perk on /buy!");
	      return false;
	    }
	    //Command
	    Inventory inv = Bukkit.createInventory(null, InventoryType.ANVIL);
	    p.openInventory(inv);
	    
		return true;
	}
	
}
