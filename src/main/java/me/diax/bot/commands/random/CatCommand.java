package me.diax.bot.commands.random;

import me.diax.bot.lib.command.DiaxCommand;
import me.diax.bot.lib.command.DiaxCommandDescription;
import me.diax.bot.lib.util.DiaxUtil;
import net.dv8tion.jda.core.entities.Message;

/**
 * Created by Comportment on 14/04/2017.
 * If you don't understand this, we are screwed.
 */
@DiaxCommandDescription(triggers = {"cate", "cat"})
public class CatCommand extends DiaxCommand {

    @Override
    public void execute(Message trigger, String args) {
        trigger.getChannel().sendMessage(DiaxUtil.defaultEmbed().setTitle("\uD83D\uDC31", DiaxUtil.getAvatarUrl()).setImage(DiaxUtil.getAnimal("cats")).build()).queue();
    }
}
