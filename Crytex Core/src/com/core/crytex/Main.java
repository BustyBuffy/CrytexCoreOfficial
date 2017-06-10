package com.core.crytex;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.core.crytex.Commands.Anvil;
import com.core.crytex.Commands.ClearChat;
import com.core.crytex.Commands.Discord;
import com.core.crytex.Commands.Haste;
import com.core.crytex.Commands.ItemRename;
import com.core.crytex.Commands.Nightvision;
import com.core.crytex.Commands.Speed;
import com.core.crytex.Commands.Staffchat;
import com.core.crytex.Commands.Strength;
import com.core.crytex.Commands.Twitter;
import com.core.crytex.Commands.Vote;
import com.core.crytex.Commands.Website;
import com.core.crytex.utils.Utils;

public class Main extends JavaPlugin implements CommandExecutor, Listener
{
	
	private boolean muteToggled = false;
	String title = ChatColor.AQUA + "[" + ChatColor.RED + "CrytexCore" + ChatColor.AQUA + "]";
	ArrayList<String> nofall = new ArrayList();
	
	public void onEnable()
	{
		System.out.println(title + " has enabled!");
		getCommand("nightvision").setExecutor(new Nightvision());
		getCommand("anvil").setExecutor(new Anvil());
		getCommand("clearchat").setExecutor(new ClearChat());
		getCommand("haste").setExecutor(new Haste());
		getCommand("twitter").setExecutor(new Twitter());
		getCommand("discord").setExecutor(new Discord());
		getCommand("itemrename").setExecutor(new ItemRename());
		getCommand("speed").setExecutor(new Speed());
		getCommand("strength").setExecutor(new Strength());
		getCommand("vote").setExecutor(new Vote());
		getCommand("website").setExecutor(new Website());
		getCommand("staffchat").setExecutor(new Staffchat());
	    PluginManager pm = getServer().getPluginManager();
	    pm.registerEvents(this, this);  
	}
	
	//MUTE CHAT COMMAND
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
		{
		if(!(sender instanceof Player))
		{
			sender.sendMessage("You can not use this command!");
		}
	    Player p = (Player)sender;
	    if ((cmd.getName().equalsIgnoreCase("mutechat")) && (args.length == 0)) 
	    {
	      if (!p.hasPermission("cc.mutechat")) 
	      {
	        p.sendMessage(Utils.color(this.title + " &cYou do not have permission!"));
	      } else if (p.hasPermission("cc.mutechat.bypass")) 
	      {
	        p.sendMessage(Utils.color(this.title + " &cUse /mutechat on"));
	      }
	    }
	    if ((cmd.getName().equalsIgnoreCase("mutechat")) && (args.length == 1) && (args[0].equalsIgnoreCase("on")))
	    {
	      if (!p.hasPermission("cc.mutechat.bypass")) {
	        p.sendMessage(Utils.color(this.title + " &cYou do not have permission!"));
	      }
	      if ((!muteToggled) && (p.hasPermission("cc.mutechat.bypass")))
	      {
	        muteToggled = true;
	        Bukkit.broadcastMessage(Utils.color(this.title + " &cThe chat has been muted by " + p.getDisplayName() + "!"));
	      }
	      else if ((muteToggled) && (p.hasPermission("cc.mutechat.bypass")))
	      {
	        muteToggled = false;
	        Bukkit.broadcastMessage(Utils.color(this.title + " &cThe chat has been unmuted by " + p.getDisplayName() + "!"));
	      }
	    }		
		
		//NO FALL EFFECT COMMAND
	    if (cmd.getName().equalsIgnoreCase("nofall"))
	    {
	      if (!(sender instanceof Player))
	      {
	        sender.sendMessage("You can not use this command!");
	        return true;
	      }
	      if (!sender.hasPermission("cc.nofall"))
	      {
	        sender.sendMessage(Utils.color(this.title + " &cYou do not have permission!"));
	        sender.sendMessage(Utils.color(this.title + " &cDonate for this perk at /buy!"));
	        return true;
	      }
	      if(this.nofall.contains(sender.getName()))
	      {
	    	  this.nofall.remove(sender.getName());
	          p.sendMessage(Utils.color(this.title + " &cNo fall has disabled!"));
	          return true;
	      }
	      this.nofall.add(sender.getName());
	      p.sendMessage(Utils.color(this.title + " &aNo fall has enabled!"));
	    }
	    
	    
		
		return true;
	}
	
	//MUTE CHAT EVENT
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event)
	{
	    Player p = event.getPlayer();
	    if (this.muteToggled) {
	      if (!p.hasPermission("cc.mutechat.bypass"))
	      {
	        event.setCancelled(true);
	        p.sendMessage(Utils.color(this.title + " &cThe chat is muted!"));
	      }
	      else if (p.hasPermission("cc.mutechat.bypass"))
	      {
	        event.setCancelled(false);
	      }
	      else if (!this.muteToggled) {}
	    }
	}
	//NO FALL EVENT
	@EventHandler
	public void onPlayerDamage(EntityDamageEvent event)
	  {
	    if ((event.getEntity() instanceof Player))
	    {
	      Player name = (Player)event.getEntity();
	      if ((event.getCause() == EntityDamageEvent.DamageCause.FALL) && (this.nofall.contains(name.getName()))) {
	        event.setCancelled(true);
	      }
	    }
	  }  
}
