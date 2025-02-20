package org.infernworld.infernclan.configUtil.manager;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class ConfigManager {
    public YamlConfiguration loader(JavaPlugin plugin, String str, String path) {
        String full = (path !=null) ? path + "/" + str : str;
        File file = new File(plugin.getDataFolder(), full);
        if (!file.exists()) {
            plugin.saveResource(full,false);
        }
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        return config;
    }
}
