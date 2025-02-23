package org.infernworld.infernclan.configUtil;

import lombok.Getter;
import lombok.val;
import org.infernworld.infernclan.InfernClan;
import org.infernworld.infernclan.configUtil.loaders.ConfigLoader;
import org.infernworld.infernclan.configUtil.loaders.MenuLoader;
import org.infernworld.infernclan.util.Color;

import java.util.ArrayList;
import java.util.List;

public class CreateMainMenu {
    private final InfernClan plugin;

    @Getter private int size, slotC;
    @Getter private List<Integer> list = new ArrayList<>();
    @Getter private List<String> loreC = new ArrayList<>();
    @Getter private String materialItemFor, title, materialCreateClan, nameC;

    public CreateMainMenu(InfernClan plugin) {
        this.plugin = plugin;
        this.setup();
    }

    private void setup() {
        MenuLoader cfg = new MenuLoader(plugin);
        cfg.loadMenus();
        val inv = "inv.";
        val items = "items.";
        val cc = "create-clan.";
        this.size = cfg.getCreateMainMenu().getInt(inv + "size");
        this.title = Color.colorize(cfg.getCreateMainMenu().getString(inv + "title"));
        this.materialCreateClan = cfg.getCreateMainMenu().getString(inv + items + cc + "material");
        this.slotC = cfg.getCreateMainMenu().getInt(inv + items + cc + "slot");
        this.nameC = Color.colorize(cfg.getCreateMainMenu().getString(inv + items + cc + "name"));
        this.loreC = cfg.getCreateMainMenu().getStringList(inv + items + cc + "lore").stream().map(Color::colorize).toList();
    }
}
