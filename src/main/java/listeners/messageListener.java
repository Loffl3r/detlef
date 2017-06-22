/**
 * © zekro 2017
 * @author zekro
 */

package listeners;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import core.CommandHandler;

public class messageListener extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.getMessage().getContent().startsWith("-") && event.getMessage().getAuthor().getId() != event.getJDA().getSelfUser().getId()) {

            CommandHandler.handleCommand(CommandHandler.parser.parse(event.getMessage().getContent(), event));
        }

    }

}