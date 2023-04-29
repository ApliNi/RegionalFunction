package aplini.regionalfunction;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class RegionalFunction extends JavaPlugin {
    public static RegionalFunction plugin;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        reloadConfig();
        plugin = this;

        // 注册主命令
        Objects.requireNonNull(plugin.getCommand("_rf")).setExecutor(new Command());
    }

    @Override
    public void onDisable() {

    }
}
