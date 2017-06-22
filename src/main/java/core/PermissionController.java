package core;

import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.requests.Route;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by edvzierh on 21.06.2017.
 */
public class PermissionController {
    
    public boolean check(MessageReceivedEvent event, String[] permittedRoles) {

        //System.out.println(roleStream);

        List<Role> userRoles = event.getGuild().getMember(event.getAuthor()).getRoles();
        if(userRoles.isEmpty()) {
            event.getTextChannel().sendMessage(":warning:   Sorry, " + event.getAuthor().getAsMention() + " du hast nicht die Rechte um diesen Befehl auszuführen.").queue();
        }
        for ( Role r : userRoles) {

            if(Arrays.stream(permittedRoles).parallel().anyMatch(r.getName()::contains))
                return true;
            else
                event.getTextChannel().sendMessage(":warning:   Sorry, " + event.getAuthor().getAsMention() + " du hast nicht die Rechte um diesen Befehl auszuführen.").queue();
        }
        return false;
    }
}
