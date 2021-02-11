package org.dawan.springchat.services;

import java.util.ArrayList;
import java.util.List;

import org.dawan.springchat.dto.FriendsDto;
import org.dawan.springchat.dto.UserDto;
import org.dawan.springchat.entities.Friends;
import org.dawan.springchat.repositories.FriendsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FriendsServiceImpl implements FriendsService {

	@Autowired
	private FriendsRepository friendsRepository;
	
	private UserServiceImpl userServiceImpl = new UserServiceImpl();
	
	@Override
	public List<UserDto> findByUserId(int id) {
		List<Friends> lu = friendsRepository.findByUserId(id);
		List<UserDto> res = new ArrayList<UserDto>();
		for (Friends f : lu) {
			res.add(userServiceImpl.findById(f.getFriendUser().getId()));
		}
		return res;
	}

	@Override
	public FriendsDto saveFriend(FriendsDto fDto) {
		ModelMapper m = new ModelMapper();
		Friends c = m.map(fDto, Friends.class);
		c = friendsRepository.saveAndFlush(c);
		return m.map(c, FriendsDto.class);
	}

	@Override
	public void deleteFriend(long id) {
		friendsRepository.deleteById(id);
		
	}

}
