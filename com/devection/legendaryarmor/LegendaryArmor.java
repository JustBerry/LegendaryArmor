package com.devection.legendaryarmor;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class LegendaryArmor extends JavaPlugin
{
	public void onEnable()
	{
		getLogger().info("Legendary Armor has been enabled successfully!");
	}

	public void onDisable()
	{
		getLogger().info("Legendary Armor has been disabled successfully!");
	}

	@SuppressWarnings("deprecation")
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		Player player = (Player) sender;

		// Display Name: Apollos Crest (Bold Red)
		// Enchantments:
			// Protection 5
			// Fire Protection 4
			// Unbreaking 3
			// Respiration 3
			// Aqua Affinity 1
			// Looting 3
		// Design image: http://puu.sh/jiXxX/9d23ea1741.png
		ItemStack apolloHelm = new ItemStack(Material.DIAMOND_HELMET);
		ItemMeta apolloHelmMeta = (ItemMeta) apolloHelm.getItemMeta();
		apolloHelmMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Apollos Crest");
		apolloHelmMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, false);
		apolloHelmMeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, false);
		apolloHelmMeta.addEnchant(Enchantment.DURABILITY, 3, false);
		apolloHelmMeta.addEnchant(Enchantment.OXYGEN, 3, false);
		apolloHelmMeta.addEnchant(Enchantment.WATER_WORKER, 1, false);
		apolloHelmMeta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 3, false);
		List<String> ApolloHelmLore = new ArrayList<String>();
		ApolloHelmLore.add(ChatColor.DARK_AQUA + "Legend Helmet");
		ApolloHelmLore.add(ChatColor.DARK_PURPLE + "#" + player.getDisplayName());
		ApolloHelmLore.add(ChatColor.DARK_GREEN + "Infused with Night Vision");
		//ApolloHelmLore.add(ChatColor.GREEN + );
		apolloHelmMeta.setLore(ApolloHelmLore);
		apolloHelm.setItemMeta(apolloHelmMeta);

		ItemStack aegisChestPlate = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta aegisChestMeta = (ItemMeta) aegisChestPlate.getItemMeta();
		aegisChestMeta.setDisplayName(ChatColor.DARK_GREEN + "Aegis");
		aegisChestPlate.setItemMeta(aegisChestMeta);

		ItemStack etherealsLeggings = new ItemStack(Material.DIAMOND_LEGGINGS);
		ItemMeta etherealsLeggingsMeta = (ItemMeta) etherealsLeggings.getItemMeta();
		etherealsLeggingsMeta.setDisplayName(ChatColor.DARK_GRAY + "Ethereals");
		etherealsLeggings.setItemMeta(etherealsLeggingsMeta);

		ItemStack hermesBoots = new ItemStack(Material.DIAMOND_BOOTS);
		ItemMeta hermesBootsMeta = (ItemMeta) hermesBoots.getItemMeta();
		hermesBootsMeta.setDisplayName(ChatColor.GOLD + "Hermes");
		hermesBoots.setItemMeta(hermesBootsMeta);

		if(cmd.getName().equalsIgnoreCase("legend"))
		{
			if(args.length == 0)
			{
				sender.sendMessage("Please specify what kit you want - Apollos/Aegis/Ethereals/Hermes");
			}
			if(args.length == 1)
			{
				if (args[0].equalsIgnoreCase("Apollos"))
					player.getInventory().addItem(apolloHelm);
				player.updateInventory();
				if (args[0].equalsIgnoreCase("Aegis"))
					player.getInventory().addItem(aegisChestPlate);
				player.updateInventory();
				if (args[0].equalsIgnoreCase("Ethereals"))
					player.getInventory().addItem(etherealsLeggings);
				player.updateInventory();
				if (args[0].equalsIgnoreCase("Hermes"))
					player.getInventory().addItem(hermesBoots);
				player.updateInventory();
			}
		}
		return false;
	}

	@EventHandler
	public void armorCheck (InventoryClickEvent event){
		// Reference for EventHandler

		ItemStack apolloHelm = new ItemStack(Material.DIAMOND_HELMET);
		ItemMeta apolloHelmMeta = (ItemMeta) apolloHelm.getItemMeta();
		apolloHelmMeta.setDisplayName(ChatColor.DARK_RED + "Apollos Crest");
		apolloHelm.setItemMeta(apolloHelmMeta);

		ItemStack aegisChestPlate = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta aegisChestMeta = (ItemMeta) aegisChestPlate.getItemMeta();
		aegisChestMeta.setDisplayName(ChatColor.DARK_GREEN + "Aegis");
		aegisChestPlate.setItemMeta(aegisChestMeta);

		ItemStack etherealsLeggings = new ItemStack(Material.DIAMOND_LEGGINGS);
		ItemMeta etherealsLeggingsMeta = (ItemMeta) etherealsLeggings.getItemMeta();
		etherealsLeggingsMeta.setDisplayName(ChatColor.DARK_GRAY + "Ethereals");
		etherealsLeggings.setItemMeta(etherealsLeggingsMeta);

		ItemStack hermesBoots = new ItemStack(Material.DIAMOND_BOOTS);
		ItemMeta hermesBootsMeta = (ItemMeta) hermesBoots.getItemMeta();
		hermesBootsMeta.setDisplayName(ChatColor.GOLD + "Hermes");
		hermesBoots.setItemMeta(hermesBootsMeta);


		Player player = (Player) event.getWhoClicked();

		if (player.getInventory().getHelmet()==null){
			player.removePotionEffect(PotionEffectType.NIGHT_VISION);
		}
		else if(player.getInventory().getHelmet().equals(apolloHelm)){
			player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 1));
		}
		else{
			player.removePotionEffect(PotionEffectType.NIGHT_VISION);
		}

		if (player.getInventory().getChestplate()==null){
			player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
		}
		else if(player.getInventory().getChestplate().equals(aegisChestPlate)){
			player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 2));
		}
		else{
			player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
		}

		if (player.getInventory().getLeggings()==null){
			player.removePotionEffect(PotionEffectType.INVISIBILITY);
		}
		else if (player.getInventory().getLeggings().equals(etherealsLeggings)){
			player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1));
		}
		else{
			player.removePotionEffect(PotionEffectType.INVISIBILITY);
		}

		if (player.getInventory().getBoots()==null){
			player.removePotionEffect(PotionEffectType.SPEED);
		}	
		else if(player.getInventory().getBoots().equals(hermesBoots)){
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));
		}
		else{
			player.removePotionEffect(PotionEffectType.SPEED);
		}

	}
}


