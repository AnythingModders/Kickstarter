package com.bwfcwalshy.kickstarter.commands;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Kickstarter implements CommandExecutor {
	
	public static Economy econ = null;
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		
	  if (command.getName().equalsIgnoreCase("kickstarter")){
	    if (!sender.hasPermission("kickstarter.kickstarter")){
	      sender.sendMessage(ChatColor.RED + "No permission!");
	    }
	    
	    if (args.length != 1){
	    	if(!sender.hasPermission("kickstarter.admin")){
	    		sender.sendMessage(ChatColor.RED + "Usage: /kickstarter create <project name> <target amount>");
	    		sender.sendMessage(ChatColor.RED + "Usage: /kickstarter browse");
	    		sender.sendMessage(ChatColor.RED + "Usage: /kickstarter fund <project name> <amount>");
	    		sender.sendMessage(ChatColor.RED + "Usage: /kickstarter end");
	    	}else{
	  	      sender.sendMessage(ChatColor.RED + "Usage: /kickstarter create <project name> <target amount>");
		      sender.sendMessage(ChatColor.RED + "Usage: /kickstarter browse");
		      sender.sendMessage(ChatColor.RED + "Usage: /kickstarter fund <project name> <amount>");
		      sender.sendMessage(ChatColor.RED + "Usage: /kickstarter end (name)");
	    	}
	    }
	  }
	  return false;
	}
}
