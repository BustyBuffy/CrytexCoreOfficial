package com.core.crytex.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.core.crytex.utils.Utils;

public class Discord implements CommandExecutor
{
	
	String title = ChatColor.AQUA + "[" + ChatColor.RED + "CrytexCore" + ChatColor.AQUA + "]";
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(!(sender instanceof Player))
		{
			sender.sendMessage("You can not use this command!");
		}
		
		Player p = (Player) sender;
		p.sendMessage(Utils.getLine());
		p.sendMessage("");
		p.sendMessage(Utils.color(this.title + " &e&lOur discord link is https://discord.gg/7w8dS7r"));
		p.sendMessage("");
		p.sendMessage(Utils.getLine());
		return true;
	}

}
