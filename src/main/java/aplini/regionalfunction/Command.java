package aplini.regionalfunction;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static aplini.regionalfunction.Func.func._spwan;
import static aplini.regionalfunction.RegionalFunction.plugin;


public class Command implements CommandExecutor, TabExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull org.bukkit.command.Command cmd, @NotNull String label, @NotNull String[] args) {

        // 处理子命令
        if(args[0].equals("spawn")){
            _spwan(sender);
        }

        // 重载插件
        else if(args[0].equals("_reload")){
            plugin.reloadConfig();
            sender.sendMessage("[_RF] 已完成配置重载");
        }

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull org.bukkit.command.Command cmd, @NotNull String label, @NotNull String[] args) {
        // 主命令
        if(args.length == 1){
            return List.of(
                    "spawn",
                    "_reload");
        }

        return null;
    }
}
