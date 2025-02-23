package org.infernworld.infernclan.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.infernworld.infernclan.InfernClan;
import org.infernworld.infernclan.gui.createMenuClan.CreateMainClan;
import org.jetbrains.annotations.NotNull;

public class Commands implements CommandExecutor {
    private final InfernClan plugin;
    private final CreateMainClan cmc;

    public Commands(InfernClan plugin) {
        this.plugin = plugin;
        this.cmc = new CreateMainClan(plugin);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        if (args.length == 0) {
            cmc.openCreateMenu(player);
        }
        return true;
    }
}
