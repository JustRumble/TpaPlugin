package dev.rumble.tpaplugin;

import dev.rumble.tpaplugin.cmds.Tpr;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class TpaPlugin extends JavaPlugin{

    final static String prefix = "[TpaPlugin] ";
    @Override
    public void onEnable() {
        getCommand("tpr").setExecutor(new Tpr());
        Bukkit.getConsoleSender().sendMessage(prefix + "Se incio correctamente el plugin");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(prefix + "Se desactivo correctamente el plugin");
    }
}
