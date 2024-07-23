package dev.rumble.tpaplugin.cmds;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Tpr implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("No puedes usar este comando en la consola!");
            return true;
        }
            switch (args.length){
                case 1:
                    Player to = Bukkit.getPlayer(args[0]);
                    if (to == null){sender.sendMessage("El jugador que te envio tpa esta desconectado");}

                    break;
                case 2:

                    break;
                default: sender.sendMessage("Argumentos inválidos!"); break;
                return true
            }

        }

    }
}