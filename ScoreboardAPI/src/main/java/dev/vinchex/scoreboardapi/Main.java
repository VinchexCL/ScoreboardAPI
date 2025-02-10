package dev.vinchex.scoreboardapi;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import java.util.List;

public class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
    }

    public static Main getInstance() {
        return instance;
    }

    public void setPlayerScoreboard(Player player, FileConfiguration config) {
        boolean barsEnabled = config.getBoolean("BARS-ENABLED", true);
        boolean footerEnabled = config.getBoolean("FOOTER-ENABLED", true);
        String title = config.getString("TITLE", "");
        String bars = config.getString("BARS", "");
        String footer = config.getString("FOOTER", "");
        String time = config.getString("TIME", "");
        boolean titleAnimatedEnabled = config.getBoolean("TITLE-ANIMATED.ENABLED", false);
        double titleAnimatedInterval = config.getDouble("TITLE-ANIMATED.INTERVAL", 0.3);
        List<String> titleAnimatedList = config.getStringList("TITLE-ANIMATED.TITLE");
        boolean footerAnimatedEnabled = config.getBoolean("FOOTER-ANIMATED.ENABLED", false);
        double footerAnimatedInterval = config.getDouble("FOOTER-ANIMATED.INTERVAL", 1.5);
        List<String> footerAnimatedList = config.getStringList("FOOTER-ANIMATED.FOOTER");
        List<String> lines = config.getStringList("LINES");

        ScoreboardManager manager = Bukkit.getScoreboardManager();
        if (manager == null) {
            getLogger().severe("ScoreboardManager is null. Scoreboard cannot be set.");
            return;
        }

        Scoreboard board = manager.getNewScoreboard();

        Objective objective = board.registerNewObjective("test", "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(player, title)));

        for (int i = 0; i < lines.size(); i++) {
            String line = PlaceholderAPI.setPlaceholders(player, lines.get(i));
            Score score = objective.getScore(ChatColor.translateAlternateColorCodes('&', line));
            score.setScore(lines.size() - i);
        }

        player.setScoreboard(board);

        if (titleAnimatedEnabled) {
            startAnimatedTitle(player, titleAnimatedList, titleAnimatedInterval);
        }
    }

    private void startAnimatedTitle(Player player, List<String> titleAnimatedList, double titleAnimatedInterval) {
        if (titleAnimatedList == null || titleAnimatedList.isEmpty()) {
            getLogger().severe("Title animation list is null or empty.");
            return;
        }

        new BukkitRunnable() {
            int index = 0;

            @Override
            public void run() {
                if (player.getScoreboard().getObjective(DisplaySlot.SIDEBAR) != null) {
                    player.getScoreboard().getObjective(DisplaySlot.SIDEBAR)
                            .setDisplayName(ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(player, titleAnimatedList.get(index))));
                    index = (index + 1) % titleAnimatedList.size();
                } else {
                    getLogger().severe("Objective is null. Cannot set animated title.");
                    cancel();
                }
            }
        }.runTaskTimer(this, 0L, (long) (titleAnimatedInterval * 20));
    }
}
