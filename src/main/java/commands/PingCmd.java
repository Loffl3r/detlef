package commands;

import core.PermissionController;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * Created by edvzierh on 20.06.2017.
 */
public class PingCmd implements Command {

    private final String help = "USAGE: -ping";

    private PermissionController controller = new PermissionController();
    private String[] permittedRoles = {"Master Of The Universe", "CEO", "Artificial Intelligence", "Admin", "Techniker"};

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        if (!controller.check(event, permittedRoles))
            return;

        event.getTextChannel().sendMessage("Pong!").queue();
    }

    @Override
    public String help() {
        return help;
    }

    @Override
    public void executed(boolean succsess, MessageReceivedEvent event) {
    }
}
