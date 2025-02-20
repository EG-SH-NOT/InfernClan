package org.infernworld.infernclan.gui.createMenuClan;

import lombok.val;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.infernworld.infernclan.InfernClan;
import org.infernworld.infernclan.configUtil.CreateMainMenu;
import org.infernworld.infernclan.configUtil.loaders.MenuLoader;

import java.util.List;

public class CreateMainClan {
    private Inventory inv;
    private Player player;
    private final InfernClan plugin;
    private final CreateMainMenu cmc;
    public CreateMainClan(InfernClan plugin) {
        this.plugin = plugin;
        this.cmc = new CreateMainMenu(plugin);
    }

    private void open() {
        List<Integer> list = cmc.getList();
        for (int slot : list) {
            val material = cmc.getMaterialItemFor();
        }
    }

    public void openCreateMenu(Player player) {
        this.inv = Bukkit.createInventory(null,cmc.getSize());
        this.open();
        player.openInventory(this.inv);
    }
}
