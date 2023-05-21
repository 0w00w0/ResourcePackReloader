package ai0w0.resourcepackreloader;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import java.security.MessageDigest;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.bukkit.util.Vector;
import org.bukkit.command.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ReloadCommandTab implements TabCompleter
{
  public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args)
  {
    if(sender instanceof Player)
    {
      if(command.getName().equalsIgnoreCase("packreload"))
      {
        List<String> list=new ArrayList<String>();
        switch(args.length)
        {
          case 1:
            list.add("@a");
            list.add("@s");
            for(Player p : Bukkit.getOnlinePlayers())
            {
              list.add(p.getName());
            }
          break;
          case 2:
            list.add("default");
          break;
          case 3:
            list.add("none");
          break;
          case 4:
            list.add("false");
            list.add("true");
          break;
          default:
            return list;
        }
        return list;
      }
    }
    
    return null;
  }
}