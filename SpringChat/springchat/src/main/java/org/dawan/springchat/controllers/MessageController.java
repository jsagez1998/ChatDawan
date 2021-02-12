package org.dawan.springchat.controllers;

import java.util.List;

import org.dawan.springchat.dto.MessageDto;
import org.dawan.springchat.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageController {
	
	@Autowired
	MessageService messageService;
	
	@GetMapping(value="/channel/{channelId}", produces = "application/json")
	public List<MessageDto> getMessagesByChannel(@PathVariable("channelId") long channelId) {
		return messageService.findByChannel(channelId);
	}
	
	@GetMapping(value="/user/{userId}", produces = "application/json")
	public List<MessageDto> getMessagesByUser(@PathVariable("userId") long userId) {
		return messageService.findByUser(userId);
	}
	
	@GetMapping(value="/message/{id}", produces = "application/json")
	public MessageDto getMessagesById(@PathVariable("id") long id) {
		return messageService.findById(id);
	}
	
	@PostMapping(value="/addmessage", produces = "application/json")
	public MessageDto addMessage(@RequestBody MessageDto mDto) {
		return messageService.saveMessageDto(mDto);
	}
	
	@DeleteMapping(value="/deleteMessage/{id}", produces = "application/json")
	public String deleteMessagesById(@PathVariable("id") long id) {
		try {
			messageService.deleteMessage(id);
			return "Le message a bien été supprimé";
		}catch (Exception e) {
			e.printStackTrace();
			return "Erreur : "+e.getMessage();
		}
	}
}