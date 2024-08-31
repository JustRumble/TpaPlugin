package dev.rumble.tpaplugin.cmds;

import dev.rumble.tpaplugin.TpaPlugin;
import dev.rumble.utils.ColoredMsg;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class TpaDeny implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if(!(sender instanceof Player)){
            ColoredMsg.sendToConsole(TpaPlugin.prefix + "&cNo puedes usar este comando desde la consola!");
        }
        else{
            UUID destinationUuid = TpaPlugin.tpaRequests.get(((Player) sender).getUniqueId());

            if (destinationUuid != null) {
                Player tpRequester = Bukkit.getPlayer(destinationUuid);
                if(tpRequester != null){
                    ColoredMsg.sendToPlayer(tpRequester, TpaPlugin.prefix + "&6" + sender.getName() + " &cha rechazado tu solicitud de tpa.");
                    ColoredMsg.sendToPlayer(((Player) sender), TpaPlugin.prefix + "Has &c&lrechazado &rla solicitud de tp exitosamente.");
                    TpaPlugin.tpaRequests.remove(((Player) sender).getUniqueId());
                }else{
                    ColoredMsg.sendToPlayer(((Player) sender),
                            TpaPlugin.prefix + "El jugador que te envió solicitud de tp se desconecto! "+
                                    "\nDebes usar el comando &a/tpafix&r para poder recibir más solicitudes de tp. ");
                }
            } else{
                ColoredMsg.sendToPlayer(
                        ((Player) sender), TpaPlugin.prefix +"&cNo tienes una solicitud de tp!");
            }
        }
        return true;
    }
}
