package casper.common;

import casper.camera.Log;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scoreboard.Score;
import org.bukkit.util.Consumer;
import org.bukkit.util.Vector;

import java.util.HashSet;
import java.util.Set;

public class Common implements Listener {

    static Log main;

    public Common()
    {

    }

    public Common(Log main)
    {
        this.main = main;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();    // 입장한 유저

        player.getWorld().setTime(0);

        main.resetScoreboard();

        player.setScoreboard(main.board);
        player.setGameMode(GameMode.CREATIVE);
    }

    @EventHandler
    public void onPick(PlayerPickupItemEvent e) {
        Player p = e.getPlayer();

        main.consol.sendMessage(p.getName());
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        World world = player.getWorld();

        main.l = player.getLocation();
        main.lx = main.l.getX();
        main.ly = main.l.getY();
        main.lz = main.l.getZ();

        //world.getHighestBlockAt(event.getTo()).setType(Material.ICE);
    }
}