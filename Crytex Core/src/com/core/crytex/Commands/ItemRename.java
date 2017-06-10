package com.core.crytex.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

import com.core.crytex.utils.Utils;

public class ItemRename implements CommandExecutor
{
	
	String title = ChatColor.AQUA + "[" + ChatColor.RED + "CrytexCore" + ChatColor.AQUA + "]";
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(!(sender instanceof Player))
		{
			sender.sendMessage("You can not use this command!");
		}
		Player p = (Player) sender;
		if(!p.hasPermission("cc.itemrename"))
		{
			p.sendMessage(Utils.color(this.title + " &cYou do not have permission!"));
		}
		if(args.length == 0)
		{
			return false;
		}
		
        String newName = "";
        
        for(String arg : args){
            if(newName.length() > 0)
                newName += "";
            newName+= arg;
        }
       
        newName = ChatColor.translateAlternateColorCodes('&', newName);
       
        if(p.getItemInHand() == null || p.getItemInHand().getType() == Material.AIR)
        {
            p.sendMessage(Utils.color(this.title + " &cYou must hold item that you want to rename!"));
            return true;
        }
       
        ItemMeta meta = p.getItemInHand().getItemMeta();
        meta.setDisplayName(newName);
        p.getItemInHand().setItemMeta(meta);
       
        p.sendMessage(Utils.color(this.title + " &aName changed to " + newName));  
		return true;
 }

}
