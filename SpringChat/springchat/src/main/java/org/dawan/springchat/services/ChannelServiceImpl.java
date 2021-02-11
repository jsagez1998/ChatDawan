package org.dawan.springchat.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.dawan.springchat.dto.ChannelDto;
import org.dawan.springchat.dto.MessageDto;
import org.dawan.springchat.dto.UserDto;
import org.dawan.springchat.entities.Channel;
import org.dawan.springchat.entities.Message;
import org.dawan.springchat.entities.User;
import org.dawan.springchat.repositories.ChannelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChannelServiceImpl implements ChannelService{

	@Autowired
	private ChannelRepository channelRepository;
	
	@Override
	public List<ChannelDto> findAll() {
		List<Channel> lc = channelRepository.findAll();
		List<ChannelDto> res = new ArrayList<ChannelDto>();
		for (Channel c : lc) {
			res.add(new ChannelDto(c.getId(), c.getName(),  c.getNbPlace()));
		}
		return res;
	}

	@Override
	public ChannelDto saveChannel(ChannelDto cDto) {
		ModelMapper m = new ModelMapper();
		Channel c = m.map(cDto, Channel.class);
		c = channelRepository.saveAndFlush(c);
		return m.map(c, ChannelDto.class);
	}

	@Override
	public void deleteChannel(long id) {
		channelRepository.deleteById(id);
		
	}

	@Override
	public List<ChannelDto> findChannetByTheme() {
		List<Channel> lc = channelRepository.findByTheme();
		List<ChannelDto> res = new ArrayList<ChannelDto>();
		for (Channel c : lc) {
			res.add(new ChannelDto(c.getId(), c.getName(),  c.getNbPlace()));
		}
		return res;
	}

	@Override
	public ChannelDto findById(long id) {
		Optional<Channel> opt = channelRepository.findById(id);
		ModelMapper m = new ModelMapper();
		if(opt.isPresent())
			return m.map(opt.get(), ChannelDto.class);
		else
			return null;
	}

}
