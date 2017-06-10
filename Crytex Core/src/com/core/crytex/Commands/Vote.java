package com.core.crytex.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.core.crytex.utils.Utils;

public class Vote implements CommandExecutor
{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(!(sender instanceof Player))
		{
			sender.sendMessage("You can not use this command!");
		}
		
		Player p = (Player) sender;
		p.sendMessage(Utils.getLine());
		p.sendMessage("");
		p.sendMessage(Utils.color("&e&lVote links are coming soon!"));
		p.sendMessage("");
		p.sendMessage(Utils.getLine());
		return true;
	}
	

}
