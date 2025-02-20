package org.infernworld.infernclan.configUtil;

import lombok.Getter;
import org.infernworld.infernclan.InfernClan;
import org.infernworld.infernclan.configUtil.loaders.ConfigLoader;

public class Config {
    private final InfernClan plugin;

    @Getter private int price;

    public Config(InfernClan plugin) {
        this.plugin = plugin;
        this.setup();
    }

    private void setup() {
        ConfigLoader cfg = new ConfigLoader(plugin);
        this.price = cfg.getConfig().getInt("setting.price");
    }
}
