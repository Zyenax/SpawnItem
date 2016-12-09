package net.Blxd.main.Handlers;

import net.Blxd.main.Main;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.Listener;

public class ItemHandler implements Listener{
	
	private static Main plugin;

	public ItemHandler(Main hub) {
		ItemHandler.plugin = hub;
		SpawnItem(Bukkit.getWorld("world"));
	}
	
	public void SpawnItem(final World world){
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable(){
		public void run() {
			for(Chunk chunk : world.getLoadedChunks()){
				for (int x = 0; x < 16; x++) {
		            for (int z = 0; z < 16; z++) {
		                for (int y = 0; y < 256; y++) {
		                    Block b = chunk.getBlock(x, y, z);
		                    if(b.getType().equals(Material.GRASS)){
		                    	b.setType(Material.GOLD_BLOCK);
		                    }
		                }
		            }
		        }
			}
		}
		}, 0, 20);
	}

}
