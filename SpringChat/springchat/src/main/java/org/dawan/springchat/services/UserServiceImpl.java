package org.dawan.springchat.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.dawan.springchat.dto.UserDto;
import org.dawan.springchat.entities.Users;
import org.dawan.springchat.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@Transactional
@CrossOrigin(origins="http://localhost:3000/")
@RequestMapping(value="/users")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto saveOrUpdate(UserDto uDto) {
		ModelMapper m = new ModelMapper();
		Users c = m.map(uDto, Users.class);
		c = userRepository.saveAndFlush(c);
		return m.map(c, UserDto.class);
	}

	@Override
	public UserDto findById(long id) {
		Optional<Users> opt = userRepository.findById(id);
		ModelMapper m = new ModelMapper();
		if(opt.isPresent())
			return m.map(opt.get(), UserDto.class);
		else
			return null;
	}

	@Override
	public void deleteUser(long id) {
		userRepository.deleteById(id);

	}

	@Override
	public List<UserDto> findByName(String name) {
		List<Users> lc = userRepository.findByName(name);
		List<UserDto> res = new ArrayList<UserDto>();
		for (Users c : lc) {
			res.add(new UserDto(c.getUsername(), c.getEmail(), c.getAge(), c.getImage(), c.getSexe(), c.getVille(), c.getDepartement(), c.getPassword()));
		}
		return res;
	}

	@Override
	public List<UserDto> findByTheme(String theme) {
		List<Users> lc = userRepository.findByTheme(theme);
		List<UserDto> res = new ArrayList<UserDto>();
		for (Users c : lc) {
			res.add(new UserDto(c.getId(), c.getUsername(), c.getEmail(), c.getAge(), c.getImage(), c.getSexe(), c.getVille(), c.getDepartement(),
					c.getRole()));
		}
		return res;
	}

	@Override
	public List<UserDto> findByPlace(String place) {
		List<Users> lc = userRepository.findByPlace(place);
		List<UserDto> res = new ArrayList<UserDto>();
		for (Users c : lc) {
			res.add(new UserDto(c.getId(), c.getUsername(), c.getEmail(), c.getAge(), c.getImage(), c.getSexe(), c.getVille(), c.getDepartement(),
					c.getRole()));
		}
		return res;
	}

	@Override
	public List<UserDto> getAllUsers(int page, int limite) {
//		List<User> lc = userRepository.findAll();
//		List<UserDto> res = new ArrayList<UserDto>();
//		for (User c : lc) {
//			res.add(new UserDto(c.getId(), c.getName(), c.getEmail(), c.getAge(), c.getImage(), c.getSex(), c.getVille(), c.getDepartement(),
//					c.isModo()));
//		}
//		return res;
		return null;
	}

	@Override
	public List<UserDto> findAll() {
		List<Users> lc = userRepository.findAll();
		List<UserDto> res = new ArrayList<UserDto>();
		for (Users c : lc) {
			res.add(new UserDto(c.getId(), c.getUsername(), c.getEmail(), c.getAge(), c.getImage(), c.getSexe(), c.getVille(), c.getDepartement(),
					c.getRole(),c.getThemes(),c.getMessages(),c.getUserChannel(), c.getFriendOf(),c.getFriends()));
		}
		return res;
	}

}
