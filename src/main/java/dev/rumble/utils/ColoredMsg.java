package dev.rumble.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ColoredMsg {
    public static void sendToConsole(String msg){
        Bukkit.getConsoleSender().sendMessage(
                ChatColor.translateAlternateColorCodes('&', msg)
        );
    }
    public static void sendToPlayer(Player p, String msg){
        p.sendMessage(
                ChatColor.translateAlternateColorCodes('&', msg)
        );
    }
}
