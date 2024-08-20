package dev.rumble.tpaplugin.cmds;

import dev.rumble.tpaplugin.TpaPlugin;
import dev.rumble.utils.ColoredMsg;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class TpaFix implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if(sender instanceof Player){
            UUID uuid = TpaPlugin.tpaRequests.remove(((Player) sender).getUniqueId());
            if(uuid != null)
                ColoredMsg.sendToPlayer(((Player) sender),
                        TpaPlugin.prefix +"&a&lAhora puedes volver a recibir solicitudes de tp!&r\n"
                                +"En caso de que no sea así, avisar a PyRumble para que pueda arreglar este plugin todo bug xd");
            else ColoredMsg.sendToPlayer(((Player) sender),
                    TpaPlugin.prefix + "No hay nada que arreglar");
        }else ColoredMsg.sendToConsole("&cNo puedes usar este comando desde la consola!");
        return true;
    }
}
