package com.lirugo.barbershopMrWhite;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;

@Configuration
@ComponentScan(value = "com.lirugo.barbershopMrWhite")
@RequiredArgsConstructor
public class TelegramBotConfig {

    @Bean
    public Bot telegramBot() {
        ApiContextInitializer.init();
        return new Bot();
    }

    @Bean
    public TelegramBotsApi telegramBotsApi() {
        return new TelegramBotsApi();
    }

}
