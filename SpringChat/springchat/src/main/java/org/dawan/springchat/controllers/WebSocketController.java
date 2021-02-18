package org.dawan.springchat.controllers;

import org.dawan.springchat.entities.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
	
	
	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/publicChatRoom")
	public Message sendMessage(@Payload Message chatMessage) {
		return chatMessage;
	}
	
	@MessageMapping("/chat.addUser")
	@SendTo("/topic/publicChatRoom")
	public Message addUser(@Payload Message chatMessage,SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", chatMessage.getUser().getUsername());
		return chatMessage;
	}
}
