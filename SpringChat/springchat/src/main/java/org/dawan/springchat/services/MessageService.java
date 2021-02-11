package org.dawan.springchat.services;

import java.util.List;

import org.dawan.springchat.dto.MessageDto;

public interface MessageService {
	
	List<MessageDto> findByChannel();
	
	MessageDto findById(long id);
	
	MessageDto saveMessageDto(MessageDto mDto);
	
	List<MessageDto> findByUser();
	
	void deleteMessage(long id);
}
