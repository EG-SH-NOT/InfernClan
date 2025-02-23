package org.infernworld.infernclan.gui.createMenuClan;

import lombok.val;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.infernworld.infernclan.InfernClan;
import org.infernworld.infernclan.configUtil.CreateMainMenu;

public class CreateMainClanEvent implements Listener {
    private final InfernClan plugin;
    private final CreateMainMenu cmc;
    public CreateMainClanEvent(InfernClan plugin) {
        this.plugin = plugin;
        this.cmc = new CreateMainMenu(plugin);
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equalsIgnoreCase(cmc.getTitle())) {
            e.setCancelled(true);
            val slot = e.getSlot();
            if (slot == cmc.getSlotC()) {
                e.getInventory().close();
            }
        }
    }
}
