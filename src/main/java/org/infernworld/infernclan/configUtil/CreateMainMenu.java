package org.infernworld.infernclan.configUtil;

import lombok.Getter;
import lombok.val;
import org.infernworld.infernclan.InfernClan;
import org.infernworld.infernclan.configUtil.loaders.ConfigLoader;
import org.infernworld.infernclan.configUtil.loaders.MenuLoader;

import java.util.ArrayList;
import java.util.List;

public class CreateMainMenu {
    private final InfernClan plugin;

    @Getter private int size;
    @Getter private List<Integer> list = new ArrayList<>();
    @Getter private String materialItemFor;

    public CreateMainMenu(InfernClan plugin) {
        this.plugin = plugin;
        this.setup();
    }

    private void setup() {
        MenuLoader cfg = new MenuLoader(plugin);
        val inv = "inv.";
        this.materialItemFor = cfg.getCreateMainMenu().getString(inv + "items-for.material");
        this.size = cfg.getCreateMainMenu().getInt(inv + "size");
        this.list = cfg.getCreateMainMenu().getIntegerList(inv + "items-for.items");
    }
}
