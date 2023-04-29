package aplini.regionalfunction.Func;

import aplini.regionalfunction.RegionalFunction;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static aplini.regionalfunction.Func.run.runConfig;

import java.util.List;
import java.util.Map;

public class func {

    public static boolean _spwan(CommandSender sender){
        // 如果是玩家
        if(sender instanceof Player player){
            // 获取玩家所在的世界名
            String playerWorldName = player.getWorld().getName();
            // 遍历配置
            for(Map<?, ?> funcConfig : RegionalFunction.plugin.getConfig().getMapList("spawn")){
                for(Object aWorldName : (List<?>) funcConfig.get("worlds")){
                    aWorldName = aWorldName.toString();
                    if(aWorldName.equals(playerWorldName)){
                        return runConfig(funcConfig, sender);
                    }
                }
            }
        }
        return false;
    }
}
