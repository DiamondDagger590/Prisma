package us.eunoians.prisma;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/**
 * @author DiamondDagger590 and OxKitsune
 */
public class Prisma extends JavaPlugin {

    @Override
    public void onEnable() {

        // Make sure the datafolder exists
        if (!this.getDataFolder().exists()) {
            this.getDataFolder().mkdirs();
        }

        // Make sure the colour file exists
        File colorFile = new File("colors.yml");
        if (!colorFile.exists()) {
            IOUtil.saveResource(this, colorFile.getPath(), false);
        }

        // Instantiate the colour provider
        ColorProvider.init(this);
    }
}