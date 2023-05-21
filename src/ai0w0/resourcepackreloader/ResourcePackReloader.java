package ai0w0.resourcepackreloader;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.file.FileConfiguration;

public final class ResourcePackReloader extends JavaPlugin
{
    public static ResourcePackReloader plugin=null;
    
    public static String defaultPack=null;
    public static String packSha1=null;
    public static Boolean isForce=null;
    public static String promptMessage=null;
    
    public void onLoad()
    {
        plugin=this;
    }
    
    public void onEnable()
    {
      plugin.saveDefaultConfig();
      
      FileConfiguration config=plugin.getConfig();
      
      defaultPack=config.getString("resource-pack");
      if(defaultPack!=null&&!defaultPack.equals(""))
      {
        packSha1=config.getString("resource-pack-sha1");
        isForce=config.getBoolean("require-resource-pack");
        promptMessage=config.getString("resource-pack-prompt");
      }
      else
      {
        defaultPack=null;
      }
      
      PluginManager pm = Bukkit.getServer().getPluginManager();
      pm.registerEvents(new JoinEvent(),this);
      
      PluginCommand statuspack=this.getCommand("packstatus");
      statuspack.setExecutor(new PackStatusCommand());
      
      PluginCommand reloadpack=this.getCommand("packreload");
      reloadpack.setTabCompleter(new ReloadCommandTab());
      reloadpack.setExecutor(new ReloadCommand());
      
      PluginCommand setdefaultresourcepack=this.getCommand("setdefaultresourcepack");
      setdefaultresourcepack.setTabCompleter(new SetDefaultPackCommandTab());
      setdefaultresourcepack.setExecutor(new SetDefaultPackCommand());
    }
    
    public void onDisable()
    {
        
    }
}
