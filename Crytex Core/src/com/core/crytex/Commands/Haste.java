package com.core.crytex.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Haste implements CommandExecutor
{
	
	  String title = ChatColor.AQUA + "[" + ChatColor.RED + "CrytexCore" + ChatColor.AQUA + "]";

	  public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	  {
	    if (!(sender instanceof Player)) {
	      sender.sendMessage("You can not use this command!");
	    }
	    Player p = (Player)sender;
	    if (!p.hasPermission("cc.haste"))
	    {
	      p.sendMessage(this.title + ChatColor.RED + " You do not have permission!");
	      p.sendMessage(this.title + ChatColor.RED + " Donate for this perk on /buy!");
	    }
	    else if (!p.hasPotionEffect(PotionEffectType.FAST_DIGGING))
	    {
	      p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 80000, 1));
	      p.sendMessage(this.title + ChatColor.GREEN + " You have enabled the haste effect!");
	    }
	    else if (p.hasPotionEffect(PotionEffectType.FAST_DIGGING))
	    {
	      p.removePotionEffect(PotionEffectType.FAST_DIGGING);
	      p.sendMessage(this.title + ChatColor.RED + " You have disabled the haste effect!");
	    }
	    return true;
	  }
}
