package net.Blxd.main;

import net.Blxd.main.Handlers.ItemHandler;
import net.Blxd.main.utils.Utils;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{

	public void onEnable(){
		Listeners();
		for(Entity entity : Bukkit.getWorld("world").getEntities()){
			if(!(entity instanceof Player)){
				entity.remove();
			}
		}
		ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        console.sendMessage(Utils.color("&8&l[&e&lItemSpawner&8&l] &aPlugin Enabled"));
	}
	
	public void onDisable(){
		ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        console.sendMessage(Utils.color("&8&l[&e&lItemSpawner&8&l] &cPlugin Disabled"));
	}
	
	public void Listeners(){
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new Utils(this), this);
		pm.registerEvents(new ItemHandler(this), this);
	}
	
}
