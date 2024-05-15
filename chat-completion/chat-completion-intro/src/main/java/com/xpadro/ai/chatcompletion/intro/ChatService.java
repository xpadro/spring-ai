package com.xpadro.ai.chatcompletion.intro;

import org.springframework.ai.chat.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    private final ChatClient chatClient;

    public ChatService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String chat(String message) {
        return chatClient.call(message);
    }
}
