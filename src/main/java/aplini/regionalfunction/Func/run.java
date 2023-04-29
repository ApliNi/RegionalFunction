package aplini.regionalfunction.Func;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import static org.bukkit.Bukkit.getLogger;

import java.util.List;
import java.util.Map;

import static aplini.regionalfunction.utils.placeholder.runPlaceholder;

public class run {

    public static boolean runConfig(Map<?, ?> funcConfig, CommandSender sender){
        boolean s = false;

        for(Object _thisConfig : (List<?>)funcConfig.get("run")){
            Map<?, ?> thisConfig = (Map<?, ?>) _thisConfig;

            // 玩家运行指令
            if(thisConfig.get("playerRunCommand") != null){
                if(sender instanceof Player player){
                    player.performCommand(runPlaceholder(thisConfig.get("playerRunCommand").toString(), player));
                    s = true;
                }
            }

            // 控制台运行指令
            if(thisConfig.get("runConsoleCommand") != null){
                if(sender instanceof Player player) {
                    String command = runPlaceholder(thisConfig.get("runConsoleCommand").toString(), player);
                    getLogger().info("[_RF] 控制台运行指令: "+ command);
                    Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), command);
                    s = true;
                }
            }

            // 发送消息
            else if(thisConfig.get("playerMessage") != null){
                sender.sendMessage(thisConfig.get("message").toString());
            }
        }

        return s;
    }
}
