package Commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class HelloCommand extends ListenerAdapter {

    public void onSlashCommand(SlashCommandInteractionEvent event){
        //Triggers if the user issues the command with this word/phrase included
        if(event.getName().equals(/*This is the trigger word*/ "hello")){
            //The bot's reply to the command
            event.reply("Hi.").queue();
        }
    }

}
