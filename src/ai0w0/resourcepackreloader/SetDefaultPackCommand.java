package ai0w0.resourcepackreloader;

import org.bukkit.command.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class SetDefaultPackCommand implements CommandExecutor
{
    private ResourcePackReloader plugin=ResourcePackReloader.plugin;
    
    public boolean onCommand ( CommandSender sender, Command command, String label, String [] args )
    {
          String url=null;
          String sha1=null;
          Boolean force=false;
          String promptMessage=null;
          
          switch(args.length)
          {
            default:
            case 4:
              promptMessage=args[3];
            case 3:
              if(args[2].equals("true"))
              {
                force=true;
              }
              else if(args[2].equals("false"))
              {
                force=false;
              }
              else
              {
                sender.sendMessage("Invalid boolean, expected 'true' or 'false' but found '"+args[2]+"'");
                return false;
              }
            case 2:
              if(!args[1].equals("none"))
              {
                if(args[1].length()!=40)
                {
                  sender.sendMessage("'"+args[1]+"' is not sha1");
                  return false;
                }
                sha1=args[1];
              } 
            case 1:
              if(!args[0].equals("default"))
              {
                url=args[0];
              }
            case 0:
          }
          
          plugin.defaultPack=url;
          plugin.isForce=force;
          plugin.packSha1=sha1;
          plugin.promptMessage=promptMessage;

          sender.sendMessage("resourcepack set complete");
          plugin.getCommand("packstatus").execute(sender,label,new String[]{});
          
          return true;
    }
}