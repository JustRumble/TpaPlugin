package dev.rumble.tpaplugin;

import dev.rumble.tpaplugin.cmds.*;
import org.bukkit.plugin.java.JavaPlugin;
import dev.rumble.utils.ColoredMsg;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;


public final class TpaPlugin extends JavaPlugin{
    public static ConcurrentHashMap<UUID, UUID> tpaRequests = new ConcurrentHashMap<>();
    public final static String prefix = "&6&l[TpaPlugin]&r ";
    @Override
    public void onEnable() {
        getCommand("tpa").setExecutor(new Tpa());
        getCommand("tpaaccept").setExecutor(new TpaAccept());
        getCommand("tpadeny").setExecutor(new TpaDeny());
        getCommand("tpafix").setExecutor(new TpaFix());
        ColoredMsg.sendToConsole(prefix + "El plugin se inicio &acorrectamente\n\t&rVersion: "
                +"&6"+ getDescription().getVersion()
                + " &r| Desarrollador: &9Rumble.&epy"
        );
    }

    @Override
    public void onDisable() {
        ColoredMsg.sendToConsole(prefix + "Se desactivo &acorrectamente el plugin\n"
                + "¡Gracias por usar mi plugin!\n-Rumble.py ");
    }
}
