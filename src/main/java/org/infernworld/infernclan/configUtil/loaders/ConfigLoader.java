package org.infernworld.infernclan.configUtil.loaders;

import lombok.AccessLevel;
import lombok.Getter;
import org.bukkit.configuration.file.YamlConfiguration;
import org.infernworld.infernclan.InfernClan;
import org.infernworld.infernclan.configUtil.manager.ConfigManager;

public class ConfigLoader {
    @Getter(AccessLevel.NONE)
    private final InfernClan plugin;
    @Getter private YamlConfiguration config;
    @Getter private YamlConfiguration messages;

    public ConfigLoader(InfernClan plugin) {
        this.plugin = plugin;
    }

    public void load(){
        ConfigManager m = new ConfigManager();
        config = m.loader(plugin,"config.yml",null);
        messages = m.loader(plugin,"message.yml",null);
    }

}
