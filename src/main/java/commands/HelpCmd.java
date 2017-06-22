package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;

/**
 * Created by edvzierh on 22.06.2017.
 */
public class HelpCmd implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        EmbedBuilder helpMsg = new EmbedBuilder().setColor(Color.green).setDescription("**Sonstiges**\n\n:arrow_forward: **help** - `Gibt diese Hilfe-Nachricht aus`");

        event.getTextChannel().sendMessage(/*":clipboard:  _**COMMAD LIST**_  :clipboard:\n\n\n" + */helpMsg.build()).queue();
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
