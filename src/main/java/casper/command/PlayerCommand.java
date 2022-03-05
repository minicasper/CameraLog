package casper.command;

import casper.camera.Log;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Score;
import org.bukkit.util.Vector;

public class PlayerCommand implements CommandExecutor {

    static Log main;

    public PlayerCommand()
    {

    }

    public PlayerCommand(Log main)
    {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if (s.equals("screenshot")) {
            Player p = sender.getServer().getPlayer(sender.getName());

            main.resetScoreboard();

            p.setScoreboard(main.board);

            World world = p.getWorld();
            Vector target = p.getLocation().getDirection();

            for (Entity e :p.getNearbyEntities(20, 20, 20)
            ) {
                Location location = e.getLocation();

                int highY = world.getHighestBlockAt(location).getY();
                if (!e.isDead() && location.getY() > highY)
                {
                    Score score = main.obj.getScore(e.getType().toString());

                    score.setScore(score.getScore() + 1);
                }
            }
        }

        return true;
    }
}