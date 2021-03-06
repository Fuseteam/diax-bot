package me.diax.bot.commands.statistics;

import me.diax.bot.DiaxBot;
import me.diax.bot.lib.command.DiaxCommand;
import me.diax.bot.lib.command.DiaxCommandDescription;
import me.diax.bot.lib.util.DiaxUtil;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDAInfo;
import net.dv8tion.jda.core.entities.Message;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Comportment on 14/04/2017.
 * If you don't understand this, we are screwed.
 */
@DiaxCommandDescription(triggers = {"stats", "statistics"})
public class StatisticsCommand extends DiaxCommand {

    @Override
    public void execute(Message trigger, String args) {
        List<JDA> shards = Arrays.asList(DiaxBot.SHARDS);
        trigger.getChannel().sendMessage(
                DiaxUtil.simpleEmbed(
                        String.format("**Developers:**\n[Comportment#9489](https://github.com/Comportment)- Diax Bot command library and commands.\n[Crystal#3166](https://github.com/CrystalMare)- Backend, Dependency Injection and Diax Service.\n[Nomsy#7453](https://github.com/Truency)- Diax Site developer and designer.\n[Reece#7982](https://github.com/ReeceyBoi81)- Database management.\n[NachtRaben#8307](https://github.com/NachtRaben)- Music logic, general bugfixes.\n\n **Information:**\n\uD83D\uDD2E Memory Usage: %s\n\uD83D\uDCD6 Library: JDA-%s\n♦ Shards: %s\n\uD83D\uDC64 Guilds: %s\n\uD83D\uDCDD Channels: %s\n\uD83D\uDC65 Users: %s",
                                ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 / 1024) + "Mb",
                                JDAInfo.VERSION,
                                DiaxBot.SHARDS.length,
                                shards.stream().mapToLong(jda -> jda.getGuilds().size()).sum(),
                                shards.stream().flatMap(jda -> jda.getGuilds().stream()).mapToLong(guild -> guild.getTextChannels().size() + guild.getVoiceChannels().size()).sum(),
                                shards.stream().flatMap(jda -> jda.getUsers().stream().distinct()).count()
                        )
                ).setThumbnail(DiaxUtil.getAvatarUrl()).build()
        ).queue();
    }
}