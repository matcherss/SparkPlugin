package me.matchers.spark.gui.punish;
/*/
Created by Matchers on 4/25/2021
 */

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class PunishGui implements Listener {

    public static void open(Player player, String toban) {
        Inventory inv = Bukkit.createInventory(null, 27, "§cPunish " + toban);

        ItemStack hacking = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta hackingMeta = hacking.getItemMeta();

        hackingMeta.setDisplayName("§cCheating");
        hacking.setItemMeta(hackingMeta);
        inv.setItem(0, hacking);

        ItemStack admit = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta admitMeta = admit.getItemMeta();
        admitMeta.setDisplayName("§cCheating [Admitted]");
        admit.setItemMeta(admitMeta);
        inv.setItem(1, admit);

        ItemStack spam = new ItemStack(Material.PAPER, 1);
        ItemMeta spamMeta = spam.getItemMeta();
        spamMeta.setDisplayName("§cSpamming");
        spam.setItemMeta(spamMeta);
        inv.setItem(2, spam);

        ItemStack se = new ItemStack(Material.PAPER, 1);
        ItemMeta seMeta = se.getItemMeta();
        seMeta.setDisplayName("§cSuicide Encouragement");
        seMeta.setLore(Arrays.asList("§7§m-----------------------", "§cAlso applies to encouraging self harm", "§7§m-----------------------"));
        se.setItemMeta(seMeta);
        inv.setItem(3, se);

        ItemStack bugabuse = new ItemStack(Material.HOPPER, 1);
        ItemMeta bugabuseMeta = bugabuse.getItemMeta();
        bugabuseMeta.setDisplayName("§cBug Abuse");
        bugabuse.setItemMeta(bugabuseMeta);
        inv.setItem(4, bugabuse);

        ItemStack builds = new ItemStack(Material.GRASS, 1);
        ItemMeta buildsMeta = builds.getItemMeta();
        buildsMeta.setDisplayName("§cInappropriate Builds");
        builds.setItemMeta(buildsMeta);
        inv.setItem(5, builds);

        ItemStack allying = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta allyingMeta = allying.getItemMeta();
        allyingMeta.setDisplayName("§cAllying");
        allying.setItemMeta(allyingMeta);
        inv.setItem(6, allying);

        ItemStack freezing = new ItemStack(Material.PACKED_ICE, 1);
        ItemMeta freezingMeta = freezing.getItemMeta();
        freezingMeta.setDisplayName("§cFreezing game");
        freezing.setItemMeta(freezingMeta);
        inv.setItem(7, freezing);

        ItemStack duping = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta dupingMeta = duping.getItemMeta();
        dupingMeta.setDisplayName("§cDuping");
        duping.setItemMeta(dupingMeta);
        inv.setItem(8, duping);

        ItemStack banevading = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta banevadingMeta = banevading.getItemMeta();
        banevadingMeta.setDisplayName("§cBan Evasion");
        banevading.setItemMeta(banevadingMeta);
        inv.setItem(9, banevading);

        ItemStack racism = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta racismMeta = racism.getItemMeta();
        racismMeta.setDisplayName("§cRacism");
        racism.setItemMeta(racismMeta);
        inv.setItem(10, racism);

        ItemStack refusal = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta refusalMeta = refusal.getItemMeta();
        refusalMeta.setDisplayName("§cRefusal to SS");
        refusal.setItemMeta(refusalMeta);
        inv.setItem(11, refusal);

        ItemStack blockglitch = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta blockglitchMeta = blockglitch.getItemMeta();
        blockglitchMeta.setDisplayName("§cBlock Glitching");
        blockglitch.setItemMeta(blockglitchMeta);
        inv.setItem(12, blockglitch);

        ItemStack unban = new ItemStack(Material.EMERALD_BLOCK, 1);
        ItemMeta unbanMeta = unban.getItemMeta();
        unbanMeta.setDisplayName("§a§lUnban");
        unban.setItemMeta(unbanMeta);
        inv.setItem(26, unban);

        player.openInventory(inv);
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent event) {
        if (!event.getInventory().getName().contains("§cPunish ")) {
            return;
        }
        String name = event.getInventory().getName().replace("§cPunish ", "");
        if (event.getCurrentItem() == null) {
            return;
        }

        if (event.getCurrentItem().getItemMeta() == null) {
            return;
        }

        Player staff = (Player) event.getWhoClicked();
        switch (event.getCurrentItem().getItemMeta().getDisplayName().replaceAll("§c", "")) {
            case "Cheating": {
                ban(name, "perm", "Illegal Modifications", staff);
                break;
            }
            case "Cheating [Admitted]": {
                ban(name, "14d", "Illegal Modifications [A]", staff);
                break;
            }
            case "Spamming": {
                mute(name, "15m", "Spamming", staff);
                break;
            }
            case "Suicide Encouragement": {
                mute(name, "14d", "Encouraging a player to self harm", staff);
                break;
            }
            case "Bug Abuse": {
                ban(name, "30m", "Abusing a bug or an exploit", staff);
                break;
            }
            case "Inappropriate Builds": {
                ban(name, "6h", "Creating inappropriate builds", staff);
                break;
            }
            case "Allying": {
                ban(name, "1d", "Teaming with players outside your own faction [Allying]", staff);
                break;
            }
            case "Freezing game": {
                ban(name, "12h", "Freezing your client purposefully to prevent dying", staff);
                break;
            }
            case "Duping": {
                ban(name, "30d", "Duplicating items using an exploit", staff);
                break;
            }
            case "Ban Evasion": {
                ban(name, "perm", "Evading a punishment using an alt account", staff);
                break;
            }
            case "Racism": {
                mute(name, "12h", "Discrimination of a player or group of people", staff);
                break;
            }
            case "Refusal to SS": {
                ban(name, "perm", "Refusing to screenshare", staff);
                break;
            }
            case "Block Glitching": {
                Bukkit.dispatchCommand(staff, "/warn " + name + " Block Glitching -s");
                break;
            }
            case "§a§lUnban": {
                Bukkit.dispatchCommand(staff, "/unban " + name + " -s");
                break;
            }
        }
        staff.closeInventory();
    }

    public void ban(String name, String duration, String reason, Player staff) {
        if (duration != "perm") {
            Bukkit.dispatchCommand(staff, "ban " + name + " " + duration + " " + reason + " -s");
        } else {
            Bukkit.dispatchCommand(staff, "ban " + name + " perm " + reason + " -s");
        }
    }

    public void mute(String name, String duration, String reason, Player staff) {
        if (duration != "perm") {
            Bukkit.dispatchCommand(staff, "mute " + name + " " + duration + " " + reason + " -s");
        } else {
            Bukkit.dispatchCommand(staff, "mute " + name + " perm " + reason + " -s");
        }
    }
}
