package Commands.CardGames;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.jetbrains.annotations.NotNull;

public class BlackjackEvent extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        //Triggers if the user issues the command with this word/phrase included
        if(event.getName().equals(/*This is the trigger word*/ "blackjack")){
            //The bot's reply to the command
            event.reply("Oh? You want to play blackjack? Do you want to use 1 deck or 6 decks?")
                    .addActionRow(
                            Button.primary("1", "One Deck"),
                            Button.primary("6", "Six decks")
                    )
                    .queue();
        }
    }

    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {
        if(event.getComponentId().equals("1")){
            event.reply("Okay, 1 deck").queue();
        } else if(event.getComponentId().equals("6")){
            event.reply("Okay, 6 decks").queue();
            
        }
    }
}
