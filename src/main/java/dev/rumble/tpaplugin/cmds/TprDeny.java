package dev.rumble.tpaplugin.cmds;

import dev.rumble.tpaplugin.TpaPlugin;
import dev.rumble.utils.ColoredMsg;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class TprDeny implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if(!(sender instanceof Player)){
            ColoredMsg.sendToConsole(TpaPlugin.prefix + "&cNo puedes usar este comando desde la consola!");
        }
        else{
            UUID destinationUuid = TpaPlugin.tpaRequests.get(((Player) sender).getUniqueId());
            if (destinationUuid != null) {
                Player destination = Bukkit.getPlayer(destinationUuid);
                ColoredMsg.sendToPlayer(destination, "&6" + sender.getName() + " &cha rechazado tu solicitud de tpa.");
                ColoredMsg.sendToPlayer(((Player) sender), "Has &c&lrechazado &rla solicitud de tp exitosamente.");
                TpaPlugin.tpaRequests.remove(destinationUuid);
            } else{
                ColoredMsg.sendToPlayer(((Player) sender), "&No tienes una solicitud de tp!");
            }
        }
        return true;
    }
}
