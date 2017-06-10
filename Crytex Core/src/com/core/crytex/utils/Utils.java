package com.core.crytex.utils;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.bukkit.ChatColor;

public class Utils
{
	  private static final Random random = new Random();
	  
	  public static String color(String input)
	  {
	    return ChatColor.translateAlternateColorCodes('&', input);
	  }
	  
	  public static int getRandom()
	  {
	    return random.nextInt(100);
	  }
	  
	  public static int getRandom(int min, int max)
	  {
	    return random.nextInt(max - min) + min;
	  }
	  
	  public static String getRemainingTime(long time)
	  {
	    long left = time - System.currentTimeMillis();
	    if (left < 0L) {
	      return null;
	    }
	    int seconds = (int)TimeUnit.MILLISECONDS.toSeconds(left);
	    seconds %= 60;
	    int minutes = (int)TimeUnit.MILLISECONDS.toMinutes(left);
	    minutes %= 60;
	    int hours = (int)TimeUnit.MILLISECONDS.toHours(left);
	    int days = (int)TimeUnit.MILLISECONDS.toDays(left);
	    if (days > 0) {
	      return days + "d " + hours + "h " + minutes + "m " + seconds + "s";
	    }
	    if (hours > 0) {
	      return hours + "h " + minutes + "m " + seconds + "s";
	    }
	    if (minutes > 0) {
	      return minutes + "m " + seconds + "s";
	    }
	    return seconds + "s";
	  }
	  
	  public static String getLine()
	  {
	    return color("&4&l&m========================================");
	  }
	  
	  public static String getEnchantmentColour(int level)
	  {
	    if (level == 1) {
	      return "&6";
	    }
	    if (level == 2) {
	      return "&b";
	    }
	    if (level == 3) {
	      return "&5";
	    }
	    if (level == 4) {
	      return "&4";
	    }
	    return "";
	  }
	}
