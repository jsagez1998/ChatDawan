package org.dawan.springchat.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.dawan.springchat.dto.MessageDto;
import org.dawan.springchat.entities.Message;
import org.dawan.springchat.repositories.MessageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageRepository messageRepository;
	
	@Override
	public List<MessageDto> findByChannel(long channelId) {
		List<Message> lc = messageRepository.findByChannel(channelId);
		List<MessageDto> res = new ArrayList<MessageDto>();
		for (Message c : lc) {
			res.add(new MessageDto(c.getId(), c.getMessage(),  c.getDate(), c.getPieceJointe(), c.getUser()));
		}
		return res;
	}

	@Override
	public MessageDto saveMessageDto(MessageDto mDto) {
		ModelMapper m = new ModelMapper();
		Message c = m.map(mDto, Message.class);
		c = messageRepository.saveAndFlush(c);
		return m.map(c, MessageDto.class);
	}

	@Override
	public List<MessageDto> findByUser(long userId) {
		List<Message> lc = messageRepository.findByUser(userId);
		List<MessageDto> res = new ArrayList<MessageDto>();
		for (Message c : lc) {
			res.add(new MessageDto(c.getId(), c.getMessage(),  c.getDate(), c.getPieceJointe(), c.getUser()));
		}
		return res;
	}

	@Override
	public void deleteMessage(long id) {
		messageRepository.deleteById(id);

	}

	@Override
	public MessageDto findById(long id) {
		Optional<Message> opt = messageRepository.findById(id);
		ModelMapper m = new ModelMapper();
		if(opt.isPresent())
			return m.map(opt.get(), MessageDto.class);
		else
			return null;
	}

}
