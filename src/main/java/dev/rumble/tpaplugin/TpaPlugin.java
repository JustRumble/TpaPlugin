package dev.rumble.tpaplugin;

import dev.rumble.tpaplugin.cmds.Tpr;
import dev.rumble.tpaplugin.cmds.TprAccept;
import dev.rumble.tpaplugin.cmds.TprDeny;
import org.bukkit.plugin.java.JavaPlugin;
import dev.rumble.utils.ColoredMsg;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;


public final class TpaPlugin extends JavaPlugin{
    public static ConcurrentHashMap<UUID, UUID> tpaRequests = new ConcurrentHashMap<>();
    public final static String prefix = "&6&l[TpaPlugin]&r ";
    @Override
    public void onEnable() {
        getCommand("tpr").setExecutor(new Tpr());
        getCommand("tpraccept").setExecutor(new TprAccept());
        getCommand("tprdeny").setExecutor(new TprDeny());
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
