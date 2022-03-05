package casper.camera;

import casper.command.PlayerCommand;
import casper.common.Common;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public final class Log extends JavaPlugin implements Listener {

    public ConsoleCommandSender consol = Bukkit.getConsoleSender();
    public Scoreboard board;
    public Objective obj;

    public Location l;
    public double lx;
    public double ly;
    public double lz;

    @Override
    public void onEnable() {
        // Plugin startup logic

        getServer().getPluginManager().registerEvents(new Common(this), this);

        getCommand("screenshot").setExecutor(new PlayerCommand(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void resetScoreboard() {

        board = Bukkit.getScoreboardManager().getNewScoreboard();
        obj = board.registerNewObjective("ServerName", "dummy", "발견된 개체");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
    }
}