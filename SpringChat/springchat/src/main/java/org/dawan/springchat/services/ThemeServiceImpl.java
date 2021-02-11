package org.dawan.springchat.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.dawan.springchat.dto.ChannelDto;
import org.dawan.springchat.dto.MessageDto;
import org.dawan.springchat.dto.ThemeDto;
import org.dawan.springchat.entities.Channel;
import org.dawan.springchat.entities.Theme;
import org.dawan.springchat.repositories.ThemeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ThemeServiceImpl implements ThemeService {
	
	@Autowired
	ThemeRepository themeRepository;
	
	@Override
	public List<ThemeDto> findAll() {
		List<Theme> lc = themeRepository.findAll();
		List<ThemeDto> res = new ArrayList<ThemeDto>();
		for (Theme c : lc) {
			res.add(new ThemeDto(c.getId(), c.getName(),  c.getDescription(), c.getUsers()));
		}
		return res;
	}

	@Override
	public ThemeDto findById(long id) {
		Optional<Theme> opt = themeRepository.findById(id);
		ModelMapper m = new ModelMapper();
		if(opt.isPresent())
			return m.map(opt.get(), ThemeDto.class);
		else
			return null;
	}

	@Override
	public ThemeDto findByName(String name) {
		Optional<Theme> opt = themeRepository.findByName(name);
		ModelMapper m = new ModelMapper();
		if(opt.isPresent())
			return m.map(opt.get(), ThemeDto.class);
		else
			return null;
	}

}
