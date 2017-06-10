package com.core.crytex.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChat implements CommandExecutor
{
	String title = ChatColor.AQUA + "[" + ChatColor.RED + "CrytexCore" + ChatColor.AQUA + "]";
	  
	  public boolean onCommand(CommandSender s, Command cmd, String label, String[] args)
	  {
	    Player p = (Player)s;
	    if (!p.hasPermission("cc.clearchat"))
	    {
	      p.sendMessage(this.title + ChatColor.RED + " You do not have permission to clear the chat!");
	    }
	    else
	    {
	      for (int t = 0; t < 100; t++) {
	        Bukkit.broadcastMessage("");
	      }
	      Bukkit.broadcastMessage(this.title + ChatColor.GREEN + " The chat has been cleared by " + p.getDisplayName());
	    }
	    return false;
	  }
	}