package org.dawan.springchat.services;

import java.util.List;

import org.dawan.springchat.dto.MessageDto;

public interface MessageService {
	
	List<MessageDto> findByChannel(long channelId);
	
	MessageDto findById(long id);
	
	MessageDto saveMessageDto(MessageDto mDto);
	
	List<MessageDto> findByUser(long userId);
	
	void deleteMessage(long id);
}
