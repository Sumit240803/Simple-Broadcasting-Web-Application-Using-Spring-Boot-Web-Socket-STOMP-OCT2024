package com.example.chatappdemo.controller;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
@Controller
public class WebController {
	private final SimpMessagingTemplate messagingTemplate;

    public WebController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/sendMessage") // Handles messages sent to /app/sendMessage
    @SendTo("/topic/messages") // Broadcasts messages to /topic/messages
    public String sendMessage(String message) {
        return message; // You can process the message here
    }
	@GetMapping("/home")
	public String home() {
		return "redirect:/home.html";
	}
}
