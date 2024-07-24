package dev.rumble.tpaplugin;

import dev.rumble.tpaplugin.cmds.Tpr;
import dev.rumble.tpaplugin.cmds.TprAccept;
import dev.rumble.tpaplugin.cmds.TprDeny;
import org.bukkit.plugin.java.JavaPlugin;
import dev.rumble.utils.ColoredMsg;
import java.util.HashMap;
import java.util.UUID;


public final class TpaPlugin extends JavaPlugin{
    public static HashMap<UUID, UUID> tpaRequests = new HashMap<>();
    public final static String prefix = "&l&6[TpaPlugin] ";
    @Override
    public void onEnable() {
        getCommand("tpr").setExecutor(new Tpr());
        getCommand("tpraccept").setExecutor(new TprAccept());
        getCommand("tprdeny").setExecutor(new TprDeny());
        ColoredMsg.sendToConsole(prefix + "El plugin se inicio &acorrectamente");
    }

    @Override
    public void onDisable() {
        ColoredMsg.sendToConsole(prefix + "Se desactivo &acorrectamente el plugin\n"
                + "\tGracias por usar mi plugin!");
    }
}
