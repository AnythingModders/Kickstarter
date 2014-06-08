package com.bwfcwalshy.kickstarter;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.bwfcwalshy.kickstarter.commands.MainCommand;

public class Main
  extends JavaPlugin
{
  public static Economy econ = null;
  
  public void onEnable(){
	  
	  getCommand("kickstarter").setExecutor(new MainCommand());
	  
    if (!setupEconomy())
    {
      Bukkit.getConsoleSender().sendMessage(ChatColor.RED + String.format("[%s] - Disabled due to no Vault dependency found!", 
        new Object[] { getDescription().getName() }));
      
      getServer().getPluginManager().disablePlugin(this);
      return;
    }
  }
  
  public boolean setupEconomy()
  {
    if (getServer().getPluginManager().getPlugin("Vault") == null) {
      return false;
    }
    RegisteredServiceProvider<Economy> rsp = getServer()
      .getServicesManager().getRegistration(Economy.class);
    if (rsp == null) {
      return false;
    }
    econ = (Economy)rsp.getProvider();
    return econ != null;
  }
}
