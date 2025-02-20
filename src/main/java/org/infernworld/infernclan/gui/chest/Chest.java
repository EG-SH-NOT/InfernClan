package org.infernworld.infernclan.gui.chest;

import org.infernworld.infernclan.InfernClan;
import org.infernworld.infernclan.configUtil.Config;

public class Chest {
    private final Config cfg;
    private final InfernClan plugin;

    public Chest (InfernClan plugin){
        this.plugin = plugin;
        this.cfg = new Config(plugin);
    }
}
