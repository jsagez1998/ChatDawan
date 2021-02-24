package org.dawan.springchat.controllers;

import java.util.List;

import org.dawan.springchat.dto.ChannelDto;
import org.dawan.springchat.services.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
	
	@GetMapping(value="/nameSearch",produces="application/json")
	public List<ChannelDto> searchByName(@RequestParam(name = "name")String name){
		return channelService.findChannelByName(name);
	}
	
	@GetMapping(value="/themeSearch",produces="application/json")
	public List<ChannelDto> searchByTheme(@RequestParam(name = "id")long id){
		return channelService.findChannelByTheme(id);
	}
	
	@PostMapping(value="/addChannel",consumes="application/json",produces="application/json")
	public ChannelDto addChannel(@RequestBody ChannelDto cDto) {
		return channelService.saveChannel(cDto);
	}
	
	@PutMapping(value="/updateChannel",consumes="application/json",produces="application/json")
	public ChannelDto update(@RequestBody ChannelDto cDto) {
		return channelService.saveChannel(cDto);
	}
	
	@DeleteMapping(value="{id}",produces="text/plain")
	public String remove(@PathVariable("id")long id) {
		try {
			channelService.deleteChannel(id);
			return "Le channel a bien été suprimé";
		} catch (Exception e) {
			e.printStackTrace();
			return " Error : "+e.getMessage();
		}
	}
	
}
