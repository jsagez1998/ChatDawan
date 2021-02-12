package org.dawan.springchat.controllers;

import java.util.List;

import org.dawan.springchat.dto.ChannelDto;
import org.dawan.springchat.services.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/channel")
public class ChannelController {
	
	@Autowired
	private ChannelService channelService;
	
	@GetMapping(value="/all", produces="application/json")
	public List<ChannelDto> getChannels(){
		return channelService.findAll();
	}
	
	@GetMapping(value="/{id}",produces ="application/json")
	public ChannelDto getById(@PathVariable("id")long id) {
		return channelService.findById(id);
	}
	
	
}
