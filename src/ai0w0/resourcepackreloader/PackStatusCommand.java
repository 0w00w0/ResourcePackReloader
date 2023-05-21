package ai0w0.resourcepackreloader;

import org.bukkit.command.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PackStatusCommand implements CommandExecutor
{
    private ResourcePackReloader plugin=ResourcePackReloader.plugin;
    
    public boolean onCommand ( CommandSender sender, Command command, String label, String [] args )
    {
        sender.sendMessage(
          "url: "+(plugin.defaultPack==null?"null":plugin.defaultPack)
          +"\nisForce: "+(plugin.isForce==null?"null":plugin.isForce)
          +"\nsha1: "+(plugin.packSha1==null?"null":plugin.packSha1)
          +"\nprompt message available: "+(plugin.promptMessage==null?"false":"true"));
        return true;
    }
}