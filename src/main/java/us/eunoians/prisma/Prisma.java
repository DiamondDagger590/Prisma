package us.eunoians.prisma;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Prisma extends JavaPlugin {
    
    @Override
    public void onEnable() {
        if(!this.getDataFolder().exists()){
            this.getDataFolder().mkdirs();
        }
        File colorFile = new File("colors.yml");
        if(!colorFile.exists()){
            IOUtil.saveResource(this, colorFile.getPath(), false);
        }
        new ColorProvider(this);
    }

    @Override
    public void onDisable() {
    }
}