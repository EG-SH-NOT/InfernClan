package org.infernworld.infernclan.gui.createMenuClan;

import lombok.val;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.infernworld.infernclan.InfernClan;
import org.infernworld.infernclan.configUtil.CreateMainMenu;
import org.infernworld.infernclan.configUtil.loaders.MenuLoader;
import org.infernworld.infernclan.util.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CreateMainClan {
    private Inventory inv;
    private final InfernClan plugin;
    private final CreateMainMenu cmc;
    private final MenuLoader m;

    public CreateMainClan(InfernClan plugin) {
        this.plugin = plugin;
        this.cmc = new CreateMainMenu(plugin);
        this.m = plugin.getMenuLoader();
    }

    private void open() {
        ItemStack itemC = new ItemStack(Material.valueOf(cmc.getMaterialCreateClan()));
        ItemMeta metaC = itemC.getItemMeta();
        metaC.setDisplayName(cmc.getNameC());

        metaC.setLore(cmc.getLoreC());
        itemC.setItemMeta(metaC);
        this.inv.setItem(cmc.getSlotC(),itemC);
        ConfigurationSection items = m.getCreateMainMenu().getConfigurationSection("inv.items-for");
        for (String key : items.getKeys(false)) {
            ConfigurationSection itemSel = items.getConfigurationSection(key);
            val material = itemSel.getString("material");
            Object slot = itemSel.get("slot");

            List<Integer> slots = new ArrayList<>();
            if (slot instanceof Integer) {
                slots.add(itemSel.getInt("slot"));
            } else if (slot instanceof List) {
                slots = itemSel.getIntegerList("slot");
            }

            val name = itemSel.getString("name");
            val lore = itemSel.getStringList("lore").stream().map(Color::colorize).toList();
            ItemStack item = new ItemStack(Material.valueOf(material));
            ItemMeta meta = item.getItemMeta();

            meta.setDisplayName(name);
            meta.setLore(lore);
            item.setItemMeta(meta);
            for (Integer slott : slots) {
                this.inv.setItem(slott, item);
            }
        }
    }

    public void openCreateMenu(Player player) {
        this.inv = Bukkit.createInventory(null, cmc.getSize(), cmc.getTitle());
        this.open();
        player.openInventory(this.inv);
    }
}
