package us.eunoians.prisma;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class PrismaCommand implements CommandExecutor {
    private final Prisma prisma;
    private ChatColor color;

    protected PrismaCommand(Prisma prisma) {
        this.prisma = prisma;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //Pick a random color from the enum to use for the text
        color = ChatColor.of(PrismaColor.values()[new Random().nextInt(PrismaColor.values().length)].getHex());

        if (args.length != 0) {
            if (args[0].equals("reload")) {
                if (sender.hasPermission("prisma.reload") || !(sender instanceof Player)) {
                    ColorProvider.load(prisma);
                    sender.sendMessage(color + "colors.yml reloaded!");
                } else {
                    noPermission(sender);
                }
            } else if (args[0].equals("list")) {
                onList(sender, args);
            } else {
                onInvalidCommand(sender, args);
            }
        } else if (sender.hasPermission("prisma.reload") || sender.hasPermission("prisma.list") || !(sender instanceof Player)) {
            onInvalidCommand(sender, args);
        } else {
            noPermission(sender);
        }

        return true;
    }

    private void onInvalidCommand(CommandSender sender, String[] args) {
        sender.sendMessage(ChatColor.RED + "Invalid command!" + ChatColor.RESET + " Try " + color + "/prisma reload" + ChatColor.RESET + " or " + color + "/prisma list [page]");
    }

    private void onList(CommandSender sender, String[] args) {
        if (sender.hasPermission("prisma.list") || !(sender instanceof Player)) {
            int p;
            if (args.length == 1) {
                p = 1;
            } else {
                try {
                    p = Integer.parseInt(args[1]);
                } catch (NumberFormatException e) {
                    sender.sendMessage(color + "Invalid Number!");
                    return;
                }
            }
            final int itemsPerPage = 5;
            int pages = (int) Math.ceil(ColorProvider.getColorMap().entrySet().size() / (itemsPerPage * 1.00));
            if (p > pages || p < 1) {
                sender.sendMessage(color + "Page does not exist!");
            } else {
                ArrayList<String> messages = new ArrayList<>();
                String header = color + "Page " + ChatColor.WHITE + p + color + " / " + ChatColor.WHITE + pages + color + " ========";
                messages.add("Prisma Color Codes" + ChatColor.GRAY + ":");
                messages.add(header);
                int n = itemsPerPage * (p - 1);
                IntStream.range(n, (n + itemsPerPage)).forEach(i -> {
                    try {
                        Character c = (Character) ColorProvider.getColorMap().keySet().toArray()[i];
                        ColorProvider.RGBWrapper color = (ColorProvider.RGBWrapper) ColorProvider.getColorMap().values().toArray()[i];
                        messages.add("'" + c + "' : " + ChatColor.of(color.toHex()) + color.toHex());
                    } catch (ArrayIndexOutOfBoundsException ignored) {
                    }
                });
                messages.add(header);
                for (String msg : messages) {
                    sender.sendMessage(msg);
                }
            }
        } else {
            noPermission(sender);
        }
    }

    private void noPermission(CommandSender sender) {
        sender.sendMessage(color + "Sorry, no permission!");
    }
}
