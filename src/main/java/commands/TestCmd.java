package commands;

import com.sun.corba.se.impl.activation.CommandHandler;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * Created by edvzierh on 22.06.2017.
 */
public class TestCmd implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {


    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
