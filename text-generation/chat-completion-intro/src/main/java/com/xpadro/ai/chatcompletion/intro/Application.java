package com.xpadro.ai.chatcompletion.intro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		ChatService chatService = context.getBean(ChatService.class);
		String result = chatService.chat("Tell me a joke");
		System.out.println(result);
	}

}
