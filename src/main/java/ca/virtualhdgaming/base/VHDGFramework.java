package ca.virtualhdgaming.base;

import ca.virtualhdgaming.visuals.Title;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class VHDGFramework extends JavaPlugin {

    private static VHDGFramework instance;
    private static Logger logger;

    public static VHDGFramework getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        getLogger().info("Now running VHDG Framework...");
        instance = this;
        logger = getLogger();
        getDataFolder().mkdirs();
        printFrameworkInfo();
    }

    @Override
    public void onDisable() {
        getLogger().info(" VHDG Framework...");
    }

    private void printFrameworkInfo() {
        logger.info("-----------------------------------------------------");
        logger.info(getDescription().getName() + " v(" + getDescription().getVersion() +  ")");
        logger.info("Author(s): " + getDescription().getAuthors());
        logger.info(" ");
        logger.info(getDescription().getDescription());
        logger.info("-----------------------------------------------------");
    }

}
