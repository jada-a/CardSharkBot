import Commands.CardGames.BlackjackEvent;
import Commands.HelloCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception{
        Yaml yaml = new Yaml();
        JDA api;
        InputStream inputStream = Main.class
                .getClassLoader()
                .getResourceAsStream("config.yaml");
        Map<String, String> obj = yaml.load(inputStream);
        String token = (String) obj.values().toArray()[0];

        api = JDABuilder.createDefault(token)
                    .addEventListeners(new HelloCommand())
                .addEventListeners(new BlackjackEvent())
                    .build();

        api.updateCommands()
                .addCommands(
                        Commands.slash("hello","This command makes Decim Bot say hi to you"),
                        Commands.slash("blackjack","This command makes Decim Bot play Blackjack")
                )
                .queue();
    }
}
