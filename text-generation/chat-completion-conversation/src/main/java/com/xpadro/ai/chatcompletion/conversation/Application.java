package com.xpadro.ai.chatcompletion.conversation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.Generation;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class Application {
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		ChatClient chatClient = context.getBean(ChatClient.class);

		List<Message> messages = List.of(
				new SystemMessage("You are a helpful assistant."),
				new UserMessage("Who won the Uefa Champions League in 2009?"),
				new AssistantMessage("FC Barcelona won the UEFA Champions League in 2009. They defeated Manchester United 2-0 in the final held in Rome, Italy."),
				new UserMessage("Who scored?")
		);

		ChatResponse response = chatClient.call(new Prompt(messages));
		Generation generation = response.getResult();
		
		LOGGER.info("Finish reason: {}", generation.getMetadata().getFinishReason());
		LOGGER.info("Response: {}", generation.getOutput().getContent());
	}

}
