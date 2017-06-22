package core;

import commands.HelpCmd;
import commands.PingCmd;
import listeners.messageListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;

/**
 * Created by edvzierh on 20.06.2017.
 *
 * @author Hannes Ziereis
 */
public class Main {

    private static JDABuilder builder;

    private static String dsToken = "MzI2NjE1MTgyMTY2MTk2MjM2.DCpXtg.mSZ_iZlNk2veqnrF0QvBEcnVWnE";

    public static void main(String[] args) {

        builder = new JDABuilder(AccountType.BOT);

        builder.setToken(dsToken);
        builder.setAutoReconnect(true);

        builder.setGame(Game.of("v1.1"));

        initListeners();
        initCommands();


        try {
            builder.buildBlocking();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RateLimitedException e) {
            e.printStackTrace();
        }

    }

    public static void initListeners () {

        builder.addListener(new messageListener());
    }

    public static void initCommands() {

        CommandHandler.commands.put("ping", new PingCmd());
        CommandHandler.commands.put("help", new HelpCmd());
    }

}
