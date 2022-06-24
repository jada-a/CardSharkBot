package Commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class HelloCommand extends ListenerAdapter {

    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){
        //Triggers if the user issues the command with this word/phrase included
        if(event.getName().equals(/*This is the trigger word*/ "hello")){
            //The bot's reply to the command
            event.reply("Hello. I am Decim Bot. Would you like to play a game?").queue();
        }
    }

}
