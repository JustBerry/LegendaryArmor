package com.enjin.devection.LegendaryArmor;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
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

	}

	public void onDisable()
	{

	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		Player player = (Player) sender;

		ItemStack ApolloHelm = new ItemStack(Material.DIAMOND_HELMET);
		ItemMeta ApolloHelmMeta = (ItemMeta) ApolloHelm.getItemMeta();
		ApolloHelmMeta.setDisplayName(ChatColor.DARK_RED + "Apollos Crest");
		ApolloHelm.setItemMeta(ApolloHelmMeta);

		ItemStack AegisChestPlate = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta AegisChestMeta = (ItemMeta) AegisChestPlate.getItemMeta();
		AegisChestMeta.setDisplayName(ChatColor.DARK_GREEN + "Aegis");
		AegisChestPlate.setItemMeta(AegisChestMeta);

		ItemStack EtherealsLeggings = new ItemStack(Material.DIAMOND_LEGGINGS);
		ItemMeta EtherealsLeggingsMeta = (ItemMeta) EtherealsLeggings.getItemMeta();
		EtherealsLeggingsMeta.setDisplayName(ChatColor.DARK_GRAY + "Ethereals");
		EtherealsLeggings.setItemMeta(EtherealsLeggingsMeta);

		ItemStack HermesBoots = new ItemStack(Material.DIAMOND_BOOTS);
		ItemMeta HermesBootsMeta = (ItemMeta) HermesBoots.getItemMeta();
		HermesBootsMeta.setDisplayName(ChatColor.GOLD + "Hermes");
		HermesBoots.setItemMeta(HermesBootsMeta);

		if(cmd.getName().equalsIgnoreCase("legend"))
		{
			if(args.length == 0)
			{
				sender.sendMessage("Please specify what kit you want - Apollos/Aegis/Ethereals/Hermes");
			}
			if(args.length == 1)
			{
				if (args[0].equalsIgnoreCase("Apollos"))
					player.getInventory().addItem(ApolloHelm);
				player.updateInventory();
				if (args[0].equalsIgnoreCase("Aegis"))
					player.getInventory().addItem(AegisChestPlate);
				player.updateInventory();
				if (args[0].equalsIgnoreCase("Ethereals"))
					player.getInventory().addItem(EtherealsLeggings);
				player.updateInventory();
				if (args[0].equalsIgnoreCase("Hermes"))
					player.getInventory().addItem(HermesBoots);
				player.updateInventory();
			}
		}
		return false;
	}

	@EventHandler
	public void armorcheck (InventoryClickEvent event){   
		// Reference for EventHandler

		ItemStack ApolloHelm = new ItemStack(Material.DIAMOND_HELMET);
		ItemMeta ApolloHelmMeta = (ItemMeta) ApolloHelm.getItemMeta();
		ApolloHelmMeta.setDisplayName(ChatColor.DARK_RED + "Apollos Crest");
		ApolloHelm.setItemMeta(ApolloHelmMeta);

		ItemStack AegisChestPlate = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta AegisChestMeta = (ItemMeta) AegisChestPlate.getItemMeta();
		AegisChestMeta.setDisplayName(ChatColor.DARK_GREEN + "Aegis");
		AegisChestPlate.setItemMeta(AegisChestMeta);

		ItemStack EtherealsLeggings = new ItemStack(Material.DIAMOND_LEGGINGS);
		ItemMeta EtherealsLeggingsMeta = (ItemMeta) EtherealsLeggings.getItemMeta();
		EtherealsLeggingsMeta.setDisplayName(ChatColor.DARK_GRAY + "Ethereals");
		EtherealsLeggings.setItemMeta(EtherealsLeggingsMeta);

		ItemStack HermesBoots = new ItemStack(Material.DIAMOND_BOOTS);
		ItemMeta HermesBootsMeta = (ItemMeta) HermesBoots.getItemMeta();
		HermesBootsMeta.setDisplayName(ChatColor.GOLD + "Hermes");
		HermesBoots.setItemMeta(HermesBootsMeta);


		Player player = (Player) event.getWhoClicked();

		if (player.getInventory().getHelmet()==null){
			player.removePotionEffect(PotionEffectType.NIGHT_VISION);
		}
		else if(player.getInventory().getHelmet().equals(ApolloHelm)){
			player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 1));
		}
		else{
			player.removePotionEffect(PotionEffectType.NIGHT_VISION);
		}
		if (player.getInventory().getChestplate()==null){
			player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
		}
		else if(player.getInventory().getChestplate().equals(AegisChestPlate)){
			player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 2));
		}
		else{
			player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
		}
		if (player.getInventory().getLeggings()==null){
			player.removePotionEffect(PotionEffectType.INVISIBILITY);
		}
		else if (player.getInventory().getLeggings().equals(EtherealsLeggings)){
			player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1));
		}
		else{
			player.removePotionEffect(PotionEffectType.INVISIBILITY);
		}
		if (player.getInventory().getBoots()==null){
			player.removePotionEffect(PotionEffectType.SPEED);
		}	
		else if(player.getInventory().getBoots().equals(HermesBoots)){
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));
		}
		else{
			player.removePotionEffect(PotionEffectType.SPEED);
		}

	}
}


