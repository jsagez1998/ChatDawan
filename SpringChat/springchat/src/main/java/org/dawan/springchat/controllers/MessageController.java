package org.dawan.springchat.controllers;

import java.util.List;

import org.dawan.springchat.dto.MessageDto;
import org.dawan.springchat.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageController {
	
	@Autowired
	MessageService messageService;
	
	@GetMapping(value="/channel/{channelId}", produces = "appliction/json")
	public List<MessageDto> getMessagesByChannel(@PathVariable("channelId") long channelId) {
		return messageService.findByChannel(channelId);
	}
	
	@GetMapping(value="/user/{userId}", produces = "appliction/json")
	public List<MessageDto> getMessagesByUser(@PathVariable("userId") long userId) {
		return messageService.findByUser(userId);
	}
	
	@GetMapping(value="/message/{id}", produces = "appliction/json")
	public MessageDto getMessagesById(@PathVariable("id") long id) {
		return messageService.findById(id);
	}
	
	@GetMapping(value="/addmessage", produces = "appliction/json")
	public MessageDto addMessage(MessageDto mDto) {
		return messageService.saveMessageDto(mDto);
	}
	
	@GetMapping(value="/deleteMessage/{id}", produces = "appliction/json")
	public void deleteMessagesById(@PathVariable("id") long id) {
		messageService.deleteMessage(id);
	}
}
