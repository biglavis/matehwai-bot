package head.bot;

import Commands.Commands;
//import Games.CoinFlipGuess;
import Games.Games;
import Games.CoinFlipGuess;
import Server.UserCommands;
import Server.User;
import Server.test;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.security.auth.login.LoginException;

public class Main {
    private static final String JSON_STORE = "./data/Profile.json";
    private UserCommands game;
    private User user;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    public static String prefix = "%";

    public static void main(String[] args) throws LoginException {
        JDA jda = JDABuilder.createDefault("x").build(); //replace x with bot token 
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setActivity(Activity.playing("With fire"));
        jda.addEventListener(new Commands());
        jda.addEventListener(new UserCommands());
        jda.addEventListener(new CoinFlipGuess());
        jda.addEventListener(new Games());
        jda.addEventListener(new test());
    }


}
