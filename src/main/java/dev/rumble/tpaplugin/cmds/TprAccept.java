package dev.rumble.tpaplugin.cmds;

import dev.rumble.utils.ColoredMsg;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import dev.rumble.tpaplugin.TpaPlugin;

import java.util.UUID;

public class TprAccept implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if(!(sender instanceof Player)){
            ColoredMsg.sendToConsole( TpaPlugin.prefix + "&cEste comando no puede ser usado en la consola!");
        }else{
            UUID userUUID = TpaPlugin.tpaRequests.get(((Player) sender).getUniqueId());
            if(userUUID != null) {
                Player destination = Bukkit.getPlayer(userUUID);
                ColoredMsg.sendToPlayer(destination,  TpaPlugin.prefix + "&e" + sender.getName() + " &a&lacepto &r&6tu solicitud de tp!");
                destination.teleport(((Player) sender));
                TpaPlugin.tpaRequests.remove(destination.getUniqueId());
            }else{
                ColoredMsg.sendToPlayer(((Player) sender), TpaPlugin.prefix +  "&No tienes una solicitud de tp!");
            }
        }
        return true;
    }
}
