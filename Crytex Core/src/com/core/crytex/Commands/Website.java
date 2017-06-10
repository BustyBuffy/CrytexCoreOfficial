package com.core.crytex.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.core.crytex.utils.Utils;

public class Website implements CommandExecutor
{
	  String title = ChatColor.AQUA + "[" + ChatColor.RED + "CrytexCore" + ChatColor.AQUA + "]";
	  
	  public boolean onCommand(CommandSender s, Command cmd, String label, String[] args)
	  {
	    if (!(s instanceof Player)) {
	      s.sendMessage("You can not use this command!");
	    }
	    Player p = (Player)s;
		p.sendMessage(Utils.getLine());
		p.sendMessage("");
		p.sendMessage(Utils.color(this.title + " &e&lComing Soon!"));
		p.sendMessage("");
		p.sendMessage(Utils.getLine());
	    return false;
	  }
	}
