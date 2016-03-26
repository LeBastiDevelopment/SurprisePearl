package com.lebasti.sp;


import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;


public class RespawnListener implements Listener {

	public RespawnListener(Main plugin) {
		
	}
	
	
	 @EventHandler
	 public void onDeath(EntityDamageEvent event) {
		 
		 
	        Entity player = event.getEntity();
	        if (player instanceof Player) {
	        player.teleport(player.getWorld().getSpawnLocation());

		 }
	        
	        
	        
	        }
}
