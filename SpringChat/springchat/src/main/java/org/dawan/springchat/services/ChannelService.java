package org.dawan.springchat.services;

import java.util.List;

import org.dawan.springchat.dto.ChannelDto;

public interface ChannelService {

	List<ChannelDto> findAll();
	
	ChannelDto findById(long id);
	
	ChannelDto saveChannel(ChannelDto cDto);
	
	void deleteChannel(long id);
	
	List<ChannelDto> findChannetByTheme();
}
