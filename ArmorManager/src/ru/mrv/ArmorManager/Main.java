package ru.mrv.ArmorManager;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import com.codingforcookies.armorequip.ArmorEquipEvent;
import com.codingforcookies.armorequip.ArmorListener;
import com.codingforcookies.armorequip.ArmorType;



public class Main  extends JavaPlugin implements Listener
{
// �������� �������
//	������ ������ ��������� ��������� �������� ����� ������ 1�� ����������
//	������ ������ ��������� ��������� ���������� ����� ��������� ��-�� �� ������ �������� (��� � ������� ��� ����������� ����������)
//
// ������� ��������� ����� (������ ������ � ������) ���������� ����� ������� ����� �������
//  /createarmorset <��� ������>	
//
// ��� ���� �������� �������� ����� � ������� � �������
//
// <���������>
//    -<����>
//	  -<�����>
//	  -<�������>
//	  -<��������(�) �� ��>    (+-) �� ���
//	  -<��������(�) �� ��>    (+-) �� ���
// 
// ��� ���� � ����������� ���� NBT	


	// ����������� ��������� �����
	//
	// ������������ ���������� ��������� ���������
	// ������ �������� �������� �� 1��, 3�� � 4�� ������
	//
	// �������� ����� ���� ������ � ���������� 
	
	public void onEnable()
	{
	  System.out.println("plugin ArmorManager is  enabled");
	  
	  Bukkit.getPluginManager().registerEvents(this, this);
	 
	  getConfig().options().copyDefaults();
	  saveDefaultConfig();
	  
	  
	  // ��������������� �������  
	  getServer().getPluginManager().registerEvents(new ArmorListener(BlockedItems.getValues()), this);
	  

	  
	}


	public void onDisable()
	{
		
		saveConfig();
	}







	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		
		
		
		 if (cmd.getName().equals("createarmorset")) {
			    if ((sender instanceof Player))
			    {
			      Player player = (Player)sender;
			      
			      
			      
			      if (player.isOp()) {
			    	  player.sendMessage(ChatColor.DARK_PURPLE + "������ ������� �������� ������ ����� ������� �������");
			      }

			    }
			    else
			    {
			    
			    	
			    	try {
			    		
			    	
			    	
			    	if (args.length == 1) {
			    	System.out.println("[ArmorManager] search for player: " +  args[0]);	
			    	
			    	Player player0 = getServer().getPlayer(args[0]);
			    	if (player0 != null) {
			    		// ��������� ����� ������
			    		ToConfig(player0.getInventory().getArmorContents());
			    		
			    		
			    		
			    	}
			    	else
			    	{
			    		System.out.println("[ArmorManager] " +  args[0] + "  was not found");		
			    	}
			    	}
			    	
			    }
			    	catch (Exception e) {;}
			    	
			    }
			  }
			  
		return false;
	}


	private void ToConfig(ItemStack[] armor) {
		// ���������� ������ � ������
		
		// ��������� 4� ������� �����
	
				// 0 - �������
				// 1 - �����
				// 2 - ���������
				// 3 - ����
		ItemStack air = new ItemStack(Material.AIR, 1);
		
		
		if (armor[2] != null) 
		
		{
			if (!( getConfig().contains(armor[2].toString())) )
			{
				
			if (armor[0] != null) {			
			getConfig().addDefault(armor[2].toString() + "." + 0, armor[0]);
			}
			else {
				getConfig().addDefault(armor[2].toString() + "." + 0, air);
			}
			
			
			if (armor[1] != null) {			
				getConfig().addDefault(armor[2].toString() + "." + 1, armor[1]);
				}
				else {
					getConfig().addDefault(armor[2].toString() + "." + 1, air);
				}
			
			if (armor[3] != null) {			
				getConfig().addDefault(armor[2].toString() + "." + 3, armor[3]);
				}
				else {
					getConfig().addDefault(armor[2].toString() + "." + 3, air);
					
				}
			
			
			
			
			getConfig().options().copyDefaults(true);
			saveConfig();
			
			System.out.println("[ArmorManager] created new armor set: " + armor[2].toString());
		}
			else {
				System.out.println("[ArmorManager] armor set already exist, skipping");
			}
			
			
			}
		else
			{
				System.out.println("[ArmorManager] slot of chestplate is empty {cant create armor set}");
			}

		
		}
			
			
			

	
	
	
	
		
		private ItemStack SpecialPreparation(ItemStack main ) {
	
			ItemStack ret = new ItemStack(main); 
			//ret.setDurability(base.getDurability());
			  ItemMeta meta = ret.getItemMeta();
			
			meta.setUnbreakable(true);
												
			meta.addEnchant(Enchantment.BINDING_CURSE , 1, false);
			meta.addEnchant(Enchantment.VANISHING_CURSE , 1, false);
			
			
			ret.setItemMeta(meta);
			
		
		return ret;
		}
	

	
	////////////////////////////////////////////////////////////////////
	// ��������� �������
		private void ItemsFromConfig (ItemStack further,ItemStack previous,  Player player) {
			
			
			
			ItemStack air = new ItemStack(Material.AIR, 1);
			
		
			if (further != null && further.getType() != Material.AIR) {
				// ��������������� ������ ��� �����
				
				// �������� ��������� ��� ������ �� �������
				ItemStack chestplate  = new ItemStack(further); 
				chestplate.setDurability((short) 0);
				
				//System.out.println("not empty ===> " + chestplate.toString()); // �����
				
				
				if (getConfig().contains(chestplate.toString()))
				{
					// ��� ��������� ����� ���������� ���
					
					// ��������� �������
					ItemStack Part0 = getConfig().getItemStack(chestplate.toString() + "." + 0);
					if (Part0 != null) {	
					
					player.getInventory().setBoots(SpecialPreparation(Part0)); 
					} 
					else {player.getInventory().setBoots(air);}
					
					
					// ��������� ������
					ItemStack Part1 = getConfig().getItemStack(chestplate.toString() + "." + 1);
					if (Part1 != null) {
					
					player.getInventory().setLeggings(SpecialPreparation(Part1)); 
					} 
					else {player.getInventory().setLeggings(air);}
					
					
					// ��������� �����
					ItemStack Part3 = getConfig().getItemStack(chestplate.toString() + "." + 3);
					if (Part3 != null) {
					
					player.getInventory().setHelmet(SpecialPreparation(Part3)); 
					}
					else {player.getInventory().setHelmet(air);}
					
					
					
					
					
				}
				else {
					// ����������� �����, �� ��������� � �������
					return;
					
				}				
				
			}
			else 
			{
				// ����� ������
				
				if (previous != null) {
				if (getConfig().contains(previous.toString())) {
					// � ������� ������� ��� �����
					//System.out.println("YES " + previous.toString() );
					// ���������  ������ 
					player.getInventory().setBoots(air); // 0
					player.getInventory().setLeggings(air); // 1
					player.getInventory().setHelmet(air); // 3
					
				}
				else {
					//  � ������� ����� ����� �� �������
					
					return;
					
				}
				
				}
			}

		
			return;
		}
		
		// ��������� ������, ���������, �������� �����
		// ����� ������� ��� � �������
	@EventHandler
	public void onChangingArmor(ArmorEquipEvent e) {
		// ������� ������� codingforcookies �� ������� ����� 	
		
	
		
		if (e.getPlayer().getGameMode() != GameMode.CREATIVE) {
			
			if ( e.getNewArmorPiece() == null) {
				ItemsFromConfig(e.getNewArmorPiece(),e.getOldArmorPiece(), e.getPlayer());	
			}
			else
			{
				
			
			if (ArmorType.matchType(e.getNewArmorPiece()) == ArmorType.CHESTPLATE || e.getNewArmorPiece().getType() == Material.AIR)
			ItemsFromConfig(e.getNewArmorPiece(),e.getOldArmorPiece(), e.getPlayer());

		}
		}
		// TODO ��� ����������� �������� �������� ���������� � ������� ������, ������� ������
		// .getPlayer() � .getNewArmorPiece() � .getOldArmorPiece()
		
		
	}
	
	







}
