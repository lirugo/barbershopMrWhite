package com.lirugo.barbershopMrWhite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

@SpringBootApplication
public class BarberMrWhiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarberMrWhiteApplication.class, args);
	}

}
