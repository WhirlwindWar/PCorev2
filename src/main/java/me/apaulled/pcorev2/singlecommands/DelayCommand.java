package me.apaulled.pcorev2.singlecommands;

import me.apaulled.pcorev2.PCorev2;
import me.apaulled.pcorev2.scheduler.PRunnable;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;

public class DelayCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        long ticks = Long.parseLong(args[0]) * 20;
        String commandString = args[1];
        String[] newArgs = Arrays.copyOfRange(args, 2, args.length);

        PCorev2.getScheduler().runTaskLater(new PRunnable() {
            public void run() { PCorev2.plugin.getCommand(commandString).execute(sender, label, newArgs); }
            public String getId() { return "delay"; }
        }, ticks);
        return true;
    }
}
