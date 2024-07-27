package dev.rumble.tpaplugin.cmds;

import dev.rumble.tpaplugin.TpaPlugin;
import dev.rumble.utils.ColoredMsg;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Tpr implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if (!(sender instanceof Player)) {
            ColoredMsg.sendToConsole(TpaPlugin.prefix + "&cNo puedes usar este comando desde la consola!");
            return true;
        }
        if (args.length == 1) {
            Player to = Bukkit.getPlayer(args[0]);
            if (to == null) {
                sender.sendMessage("El jugador está desconectado o no existe");
                return true;
            }
            if (to == sender) {
                sender.sendMessage("No puedes mandarte tpa a ti mismo.");
                return true;
            } else {
                if(TpaPlugin.tpaRequests.get(to.getUniqueId()) == null){
                    TpaPlugin.tpaRequests.put(to.getUniqueId(),((Player) sender).getUniqueId());
                    ColoredMsg.sendToPlayer(to,"Hey, " + "&e" +to.getName() + "\n"
                            +"&6" + sender.getName() + " &fte envió una solicitud para teletransportarse hacia ti, ¿Qué harás con la solicitud?");
                    TextComponent accept = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&a[La acepto, quiero que se teletansporte a mí]"));
                    accept.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/tpraccept"));
                    TextComponent deny = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&c[La rechazo, no quiero que se teletransporte a mí]"));
                    deny.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/tprdeny"));
                    to.spigot().sendMessage(accept);
                    to.spigot().sendMessage(deny);
                    ColoredMsg.sendToPlayer(((Player) sender), TpaPlugin.prefix + "&aHas enviado una solicitud de tp exitosamente a " + to.getName());
                }else ColoredMsg.sendToPlayer(((Player) sender),  TpaPlugin.prefix +"&cEste jugador ya tiene una solicitud de tp!");
            }
        } else ColoredMsg.sendToPlayer(((Player) sender),"&cUso correcto: /tpr <jugador>");
        return true;
        }

    }
