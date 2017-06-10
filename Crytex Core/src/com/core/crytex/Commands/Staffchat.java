package com.core.crytex.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.core.crytex.utils.Utils;

public class Staffchat implements CommandExecutor
{
	
	String title = ChatColor.AQUA + "[" + ChatColor.RED + "CrytexCore" + ChatColor.AQUA + "]";
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(!(sender instanceof Player))
		{
			sender.sendMessage(Utils.color("You can not use this command!"));
		}
		Player p = (Player) sender;
		if(!p.hasPermission("cc.staffchat"))
		{
			p.sendMessage(Utils.color(this.title + " &cYou do not have permission!"));
		}
		String message = "";
		String[] arrayOfString;
		int j = (arrayOfString = args).length;
		for (int i = 0; i < j; i++)
		{
	        String word = arrayOfString[i];
	        message = message + word + " ";
		}
	      for (Player player : Bukkit.getOnlinePlayers()) 
	      {
	          if (player.hasPermission("cc.staffchat")) 
	          {
	            p.sendMessage(Utils.color("&a[StaffChat] &c" + sender.getName() + " &e>> " + message));
        }
      }
		return true;
	}

	
}
