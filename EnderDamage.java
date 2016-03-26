package com.lebasti.sp;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class EnderDamage implements Listener {

   public EnderDamage(Main plugin) {
   
    }

   @EventHandler
   public void AnimalSpiritEndermanNoPearlDamage(PlayerTeleportEvent event){   // This listener doesn't work, yet(?)
       Player p = event.getPlayer();
       if(event.getCause() == PlayerTeleportEvent.TeleportCause.ENDER_PEARL){
           event.setCancelled(true);
           p.setNoDamageTicks(1); 
           p.teleport(event.getTo());
       }
   }
}
 
