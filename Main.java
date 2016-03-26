package com.lebasti.sp;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	public static Main plugin;
	public void onEnable() {
		plugin = this;
		loadConfig();
		registerEvents();
		
		getLogger().info(ChatColor.GOLD + "[SurprisePearl]" + ChatColor.WHITE + " Enabled plugin");
	}
	
	public void onDisable() {
		
		getLogger().info(ChatColor.GOLD + "[SurprisePearl]" + ChatColor.RED + " Disabled plugin");
		plugin = null;
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String args[]) {
				
		if(!(sender instanceof Player)) {
			
		getLogger().info(ChatColor.GOLD + "[SurprisePearl]" + ChatColor.RED + " Please perform this command in the chat!");
			
		}
		
		else {
			
		if(command.getName().equalsIgnoreCase("sp")) {
			
			Player p = (Player) sender;
			
			if (args.length == 0) {
				
			sender.sendMessage(ChatColor.GOLD + "[SurprisePearl]" + ChatColor.RED + "  /sp help");	
				
			}
			
			else {
				
				if(args[0].equalsIgnoreCase("Info")) {
					
					if(!p.hasPermission("SP.Info")) { 
						
					sender.sendMessage(ChatColor.GOLD + "[SurprisePearl]" + ChatColor.RED + " [ERROR] You don't have the required permission to do that");
						
					}
					
					else {
						
				    sender.sendMessage("§6[SurprisePearl] §bCredits\n§aPlugin developed by LeBasti\n§bCopyright LeBasti.com 2016");
						
					}
				}
				
                   if(args[0].equalsIgnoreCase("permissions")) {
					
					if(!p.hasPermission("SP.Perms")) { 
						
					sender.sendMessage(ChatColor.GOLD + "[SurprisePearl]" + ChatColor.RED + " [ERROR] You don't have the required permission to do that");
						
					}
					
					else {
						
				    sender.sendMessage("§6[SurprisePearl] §bPermissions\n§aSP.Help §7/SP Help Access\n"   // Perms Help
				    		+ "§aSP.Info §7/SP Info Access\n"
				    		+ "§aSP.Config §7/SP Config Reload Access "
				    		+ "§aSP.Set §7/SP Set Access"
				    		+ "§aSP.Join §7/SP Join Access "
				    		+ "§aSP.Join.Spec §7/SP Join Spec Access"
				    		+ "§aSP.Perms §7/SP Permissions Access "
				    		+ "§aSP.* §7Access to all permissions");
						
					}
				}
				
                    if(args[0].equalsIgnoreCase("Config")) { // CONFIG                                         SETTINGS! 
					
					if(!p.hasPermission("SP.Config")) { 
						
					sender.sendMessage(ChatColor.GOLD + "[SurprisePearl]" + ChatColor.RED + " [ERROR] You don't have the required permission to do that");
						
					}
					
					else{
						if(args[1].equalsIgnoreCase("reload")) {
							reloadConfig();
						sender.sendMessage("§6[SurprisePearl] §aConfig reloaded");
						}
					}
					
				
				}
			
			if(args[0].equalsIgnoreCase("help")) {
			
			if(!p.hasPermission("SP.Help")) { 
				
			sender.sendMessage(ChatColor.GOLD + "[SurprisePearl]" + ChatColor.RED + " [ERROR] You don't have the required permission to do that");
				
			}
			
			else {      // HELP                                                                   ? ? ?
				 
				sender.sendMessage("§6[SurprisePearl] §aHelp\n" + 
		        "§c/sp set help §bDisplays the set-help\n"
				+ "§c/sp join §bJoin the game\n"
				+ "§c/sp join-spec §bJoin the game as spectator\n"
				+ "§c/sp config reload §bConfig will be reloaded\n"
				+ "§c/sp permissions §bPermissions list\n"
				+ "§c/sp help §bDisplays this page\n"
				+ "§c/sp info §bAbout the plugin");
				
					
				}
				
			}
			
			if(args[0].equalsIgnoreCase("set")) {
				
				if(!p.hasPermission("SP.Set")) { 
			sender.sendMessage(ChatColor.GOLD + "[SurprisePearl]" + ChatColor.RED + " [ERROR] You don't have the required permission to do that");
				}
				
				else {
					
					if (args[1].equalsIgnoreCase("help")) {
						
						// Bukkit.broadcastMessage gl
						sender.sendMessage("§6[SurprisePearl] §bSet Help\n§c/sp set join "
							+ "§aSet the join position\n§c/sp set spec §aSet the spectator position "
							+ "§e(when a player dies he respawn automatically here)");	
						
					}
				
					 /*if(args[1].equalsIgnoreCase("join-message")) {   DOESN'T WORK BECAUSE THE ARGUMENTS (...)
						
						if(!args[2].equalsIgnoreCase("")) {
							
							plugin.getConfig().set("SPJoin.join-message", args[2]);
							
						}
						else {
						sender.sendMessage("§6[SurprisePearl] §c[ERROR] Please enter a message");
						}
					}*/
					
					if(args[1].equalsIgnoreCase("spec")) {
						
						Location loc = p.getLocation();
						
						double x = loc.getX();
						double y = loc.getY();
						double z = loc.getZ();
						
						getConfig().set("SPJoin.Spec." + ".X", x);
						getConfig().set("SPJoin.Spec." + ".Y", y);
						getConfig().set("SPJoin.Spec." + ".Z", z);
						
						saveConfig();
						p.sendMessage("§6[SurprisePearl]" + " §aSpectator position set!");
						
						World world = p.getWorld();
						Location locspawn = p.getLocation();
						world.setSpawnLocation(locspawn.getBlockX(), loc.getBlockY() + 1, loc.getBlockZ());
						
					}
				    
					if(args[1].equalsIgnoreCase("join")) {

					Location loc = p.getLocation();
					
					double x = loc.getX();
					double y = loc.getY();
					double z = loc.getZ();
					
					getConfig().set("SPJoin." + ".X", x);
					getConfig().set("SPJoin." + ".Y", y);
					getConfig().set("SPJoin." + ".Z", z);
					
					saveConfig();
					p.sendMessage("§6[SurprisePearl]" + " §aJoin position set!");
					
					
					
					}
					
				}
				}		 
			
			if(args[0].equalsIgnoreCase("join")) {
				
				if(!p.hasPermission("SP.Join")) { 
			sender.sendMessage(ChatColor.GOLD + "[SurprisePearl]" + ChatColor.RED + " [ERROR] You don't have the required permission to do that");
				}
				
				else {
				

			double x = getConfig().getDouble("SPJoin." + ".X");
			double y = getConfig().getDouble("SPJoin." + ".Y");
			double z = getConfig().getDouble("SPJoin." + ".Z");
			p.teleport(new Location(p.getWorld(), x, y, z));
			
			Boolean kICon = plugin.getConfig().getBoolean("keep-Inventory");
			if (kICon == true) {
			p.getWorld().setGameRuleValue("keepInventory", "true");
			}
			Bukkit.broadcastMessage(plugin.getConfig().getString("SPJoin.join-message"));
            
			Boolean ArmorCon = plugin.getConfig().getBoolean("Armor");
			if (ArmorCon == true) {
            
				p.getPlayer().getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
				p.getPlayer().getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
				p.getPlayer().getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
				p.getPlayer().getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
				
			}
	        p.getInventory().setItem(0, new ItemStack(Material.ENDER_PEARL, 64));
			p.getInventory().setItem(1, new ItemStack(Material.ENDER_PEARL, 64));
			p.getInventory().setItem(2, new ItemStack(Material.ENDER_PEARL, 64));
			p.getInventory().setItem(3, new ItemStack(Material.ENDER_PEARL, 64));
			p.getInventory().setItem(4, new ItemStack(Material.ENDER_PEARL, 64));
			p.getInventory().setItem(5, new ItemStack(Material.ENDER_PEARL, 64));
			p.getInventory().setItem(6, new ItemStack(Material.ENDER_PEARL, 64));
			p.getInventory().setItem(7, new ItemStack(Material.ENDER_PEARL, 64));
	        p.getInventory().setItem(8, new ItemStack(Material.ENDER_PEARL, 64));
			
					}

		
				}
			
			if(args[0].equalsIgnoreCase("join-spec")) {
				
				if(!p.hasPermission("SP.Join.Spec")) { 
					sender.sendMessage(ChatColor.GOLD + "[SurprisePearl]" + ChatColor.RED + " [ERROR] You don't have the required permission to do that");
						}
				else {

				double xe = getConfig().getDouble("SPJoin.Spec" + ".X");
				double ye = getConfig().getDouble("SPJoin.Spec" + ".Y");
				double ze = getConfig().getDouble("SPJoin.Spec" + ".Z");
				p.teleport(new Location(p.getWorld(), xe, ye, ze));
				
				Boolean kICon = plugin.getConfig().getBoolean("keep-Inventory");
				if (kICon == true) {
				p.getWorld().setGameRuleValue("keepInventory", "true");
				}
				Bukkit.broadcastMessage(plugin.getConfig().getString("SPJoin.spec-message"));
				}
			}
					
				}
			
			}


		}
		return false;

	}
	public void loadConfig() {
		
		plugin.getConfig().addDefault("SPJoin.X", 0);
		plugin.getConfig().addDefault("SPJoin.Y", 0);
		plugin.getConfig().addDefault("SPJoin.Z", 0);
		plugin.getConfig().addDefault("SPJoin.Spec.X", 0);
		plugin.getConfig().addDefault("SPJoin.Spec.Y", 0);
		plugin.getConfig().addDefault("SPJoin.Spec.Z", 0);
		
		         plugin.getConfig().addDefault("Armor", true);
		         plugin.getConfig().addDefault("keep-Inventory", true);
		         String path = "SPJoin.join-message";
			     plugin.getConfig().addDefault(path, "§6[SurprisePearl] §cYou've joined the game");
			     String path2 = "SPJoin.spec-message";
			     plugin.getConfig().addDefault(path2, "§6[SurprisePearl] §cYou're now spectator");
    	getConfig().options().copyDefaults(true);
    	saveConfig();
    }
	
	public void registerEvents() {
		
		new RespawnListener(this);
		new EnderDamage(this);
		
	}

}
