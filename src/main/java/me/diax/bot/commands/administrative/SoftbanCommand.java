package me.diax.bot.commands.administrative;

import me.diax.bot.lib.command.DiaxCommand;
import me.diax.bot.lib.command.DiaxCommandDescription;
import me.diax.bot.lib.util.DiaxUtil;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.exceptions.PermissionException;

/**
 * Created by Comportment on 12/04/2017.
 * If you don't understand this, we are screwed.
 */
@DiaxCommandDescription(triggers = {"softban"}, guildOnly = true, minimumArgs = 1, permission = Permission.BAN_MEMBERS)
public class SoftbanCommand extends DiaxCommand {

    @Override
    public void execute(Message trigger, String args) {
        trigger.getMentionedUsers().forEach(user -> {
            try {
                trigger.getGuild().getController().ban(trigger.getGuild().getMember(user), 7).queue(_void -> trigger.getGuild().getController().unban(user).queue());
                trigger.getChannel().sendMessage(DiaxUtil.simpleEmbed(DiaxUtil.makeName(user) + "has been softbanned!").build()).queue();
            } catch (PermissionException exception) {
                trigger.getChannel().sendMessage(DiaxUtil.errorEmbed("I could not softban " + DiaxUtil.makeName(user))).queue();
            }
        });
    }
}
