import Commands.HelloCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Yaml yaml = new Yaml();
        JDA api;
        InputStream inputStream = Main.class
                .getClassLoader()
                .getResourceAsStream("config.yaml");
        Map<String, String> obj = yaml.load(inputStream);

        try{
            api = JDABuilder.createDefault((String) obj.values().toArray()[0])
                    .addEventListeners(new HelloCommand())
                    .build();

            api.updateCommands()
                    .addCommands(Commands.slash("hello","This command makes Decim Bot say hi to you"))
                    .queue();
        }
        catch (Exception e){
            e.printStackTrace();

        }
    }
}
