package ai0w0.resourcepackreloader;

import java.util.ArrayList;

import org.bukkit.command.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ReloadCommand implements CommandExecutor
{
    private ResourcePackReloader plugin=ResourcePackReloader.plugin;
    
    public boolean onCommand ( CommandSender sender, Command command, String label, String [] args ) {
        try {
          
          ArrayList<Player> target=new ArrayList<Player>();
          String url=plugin.defaultPack;
          String sha1=null;
          Boolean force=true;
          String promptMessage=null;
          
          switch(args.length)
          {
            case 0:
              for (Player player : Bukkit.getOnlinePlayers())
              {
                target.add(player);
              }
            break;
            default:
            case 5:
              promptMessage=args[4];
            case 4:
              if(args[3].equals("true"))
              {
                force=true;
              }
              else if(args[3].equals("false"))
              {
                force=false;
              }
              else
              {
                sender.sendMessage("Invalid boolean, expected 'true' or 'false' but found '"+args[2]+"'");
                return false;
              }
            case 3:
              if(!args[2].equals("none"))
              {
                if(args[2].length()!=40)
                {
                  sender.sendMessage("'"+args[2]+"' is not sha1");
                  return false;
                }
                sha1=args[2];
              } 
            case 2:
              if(!args[1].equals("default"))
              {
                url=args[1];
              }
            case 1:
              if(args[0].charAt(0)=='@')
              {
                switch(args[0].charAt(1))
                {
                  case 'a':
                    for (Player player : Bukkit.getOnlinePlayers())
                    {
                      target.add(player);
                    }
                  break;
                  case 's':
                    Player t=Bukkit.getServer().getPlayer(sender.getName());
                    target.add(t);
                  break;
                  default:
                    sender.sendMessage("can't find "+args[0]);
                    return false;
                }
              }
              else
              {
                Player t=Bukkit.getServer().getPlayer(args[0]);
                if(t==null)
                {
                  sender.sendMessage("can't find "+args[0]);
                  return false;
                }
                
                target.add(t);
              }
          }
          
          
        for (Player player : target)
        {
          player.setResourcePack(url,plugin.hexStringToByteArray(sha1),promptMessage,force);
        }
        
        
        } catch (Exception e) {
          e.printStackTrace();
        }
        return true;
    }
}