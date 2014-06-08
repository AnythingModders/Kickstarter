package com.bwfcwalshy.kickstarter;

import java.io.File;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.bwfcwalshy.kickstarter.commands.Kickstarter;

public class Main
  extends JavaPlugin
{
  public static Economy econ = null;
  
  public void onEnable(){
	  File file = new File(getDataFolder(), "config.yml");
	  if(!file.exists()){
		  try{
			  file.createNewFile();
		  } catch (Exception e){
			  e.printStackTrace();
		  }
	  }
	  
	  getCommand("kickstarter").setExecutor(new Kickstarter());
	  
	  initialiseConfig();
	  
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
  
  public void initialiseConfig(){
	  FileConfiguration config = getConfig();
	  
	  config.options().copyDefaults(true);
	  saveConfig();
  }
}
