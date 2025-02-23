package org.infernworld.infernclan;

import lombok.Getter;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;
import org.infernworld.infernclan.command.Commands;
import org.infernworld.infernclan.configUtil.loaders.ConfigLoader;
import org.infernworld.infernclan.configUtil.loaders.MenuLoader;
import org.bukkit.event.Listener;
import org.infernworld.infernclan.gui.createMenuClan.CreateMainClanEvent;

import java.util.Arrays;
import java.util.List;

@Getter
public final class InfernClan extends JavaPlugin {
    private MenuLoader menuLoader;

    @Override
    public void onEnable() {
        this.loadAllCfg();
        PluginCommand command = getCommand("clan");
        command.setExecutor(new Commands(this));
        this.registerEvent();
    }

    private void loadAllCfg() {
        ConfigLoader cfgLoad = new ConfigLoader(this);
        menuLoader = new MenuLoader(this);
        menuLoader.loadMenus();
        cfgLoad.load();
    }

    private void registerEvent() {
        List<Listener> list = List.of(
                new CreateMainClanEvent(this)
        );
        for (Listener listener : list) {
            getServer().getPluginManager().registerEvents(listener, this);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
