package ai0w0.resourcepackreloader;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener
{
    private ResourcePackReloader plugin=ResourcePackReloader.plugin;
    
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
      if(plugin.defaultPack!=null&&plugin.isForce!=null)
      {
        event.getPlayer().setResourcePack(plugin.defaultPack,null,plugin.promptMessage,plugin.isForce);
      }
    }
}