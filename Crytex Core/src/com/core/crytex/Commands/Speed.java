package com.core.crytex.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Speed implements CommandExecutor
{

	  String title = ChatColor.AQUA + "[" + ChatColor.RED + "CrytexCore" + ChatColor.AQUA + "]";
	  
	  public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	  {
	    if (!(sender instanceof Player)) {
	      sender.sendMessage("You can not use this command!");
	    }
	    Player p = (Player)sender;
	    if (!p.hasPermission("cc.speed"))
	    {
	      p.sendMessage(this.title + ChatColor.RED + " You do not have permission!");
	      p.sendMessage(this.title + ChatColor.RED + " Donate for this perk on /buy!");
	    }
	    else if (!p.hasPotionEffect(PotionEffectType.SPEED))
	    {
	      p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 80000, 1));
	      p.sendMessage(this.title + ChatColor.GREEN + " You have enabled the speed effect!");
	    }
	    else if (p.hasPotionEffect(PotionEffectType.SPEED))
	    {
	      p.removePotionEffect(PotionEffectType.SPEED);
	      p.sendMessage(this.title + ChatColor.RED + " You have disabled the speed effect!");
	    }
	    return false;
	  }
}
