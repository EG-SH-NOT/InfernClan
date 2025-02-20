package org.infernworld.infernclan.configUtil.loaders;

import lombok.AccessLevel;
import lombok.Getter;
import org.bukkit.configuration.file.YamlConfiguration;
import org.infernworld.infernclan.InfernClan;
import org.infernworld.infernclan.configUtil.manager.ConfigManager;

public class MenuLoader {
    @Getter(AccessLevel.NONE)
    private final InfernClan plugin;
    @Getter private YamlConfiguration chest, mainMenu, createMainMenu;

    public MenuLoader(InfernClan plugin) {
        this.plugin = plugin;
    }

    public void loadMenus(){
        ConfigManager m = new ConfigManager();
        this.chest = m.loader(plugin,"chest.yml","menus");
        this.mainMenu = m.loader(plugin,"mainMenu.yml","menus"); // меню после создание клана
        this.createMainMenu = m.loader(plugin, "createMainClan.yml", "menus"); // Меню до создания клана
    }
}
