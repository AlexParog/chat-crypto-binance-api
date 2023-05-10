package com.application.chat.config;

import com.application.chat.entity.Bot;
import com.application.chat.processor.CommandProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BotConfiguration {

    @Bean
    public Bot bot() {
        return new Bot();
    }

    @Bean
    public CommandProcessor commandProcessor(Bot bot) {
        return new CommandProcessor(); // TODO передать bot
    }


}
