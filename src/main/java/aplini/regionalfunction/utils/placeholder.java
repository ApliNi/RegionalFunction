package aplini.regionalfunction.utils;

import org.bukkit.entity.Player;

public class placeholder {

    public static String runPlaceholder(String message, Player player){
        return message.replace("{player}", player.getName());
    }
}
