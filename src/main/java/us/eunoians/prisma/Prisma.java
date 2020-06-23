package us.eunoians.prisma;

import org.bukkit.plugin.java.JavaPlugin;

public class Prisma extends JavaPlugin {

    @Override
    public void onEnable() {
        new ColorProvider(this);
        IOUtil.saveResource(this, "colors.yml", false);
    }

    @Override
    public void onDisable() {
    }
}
