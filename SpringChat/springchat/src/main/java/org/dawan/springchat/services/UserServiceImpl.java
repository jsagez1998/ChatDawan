package org.dawan.springchat.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.dawan.springchat.dto.UserDto;
import org.dawan.springchat.entities.User;
import org.dawan.springchat.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto saveOrUpdate(UserDto uDto) {
		ModelMapper m = new ModelMapper();
		User c = m.map(uDto, User.class);
		c = userRepository.saveAndFlush(c);
		return m.map(c, UserDto.class);
	}

	@Override
	public UserDto findById(long id) {
		Optional<User> opt = userRepository.findById(id);
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
		List<User> lc = userRepository.findByName(name);
		List<UserDto> res = new ArrayList<UserDto>();
		for (User c : lc) {
			res.add(new UserDto(c.getId(), c.getName(), c.getEmail(), c.getAge(), c.getImage(), c.getSex(), c.getVille(), c.getDepartement(),
					c.isModo()));
		}
		return res;
	}

	@Override
	public List<UserDto> findByTheme(String theme) {
		List<User> lc = userRepository.findByTheme(theme);
		List<UserDto> res = new ArrayList<UserDto>();
		for (User c : lc) {
			res.add(new UserDto(c.getId(), c.getName(), c.getEmail(), c.getAge(), c.getImage(), c.getSex(), c.getVille(), c.getDepartement(),
					c.isModo()));
		}
		return res;
	}

	@Override
	public List<UserDto> findByPlace(String place) {
		List<User> lc = userRepository.findByPlace(place);
		List<UserDto> res = new ArrayList<UserDto>();
		for (User c : lc) {
			res.add(new UserDto(c.getId(), c.getName(), c.getEmail(), c.getAge(), c.getImage(), c.getSex(), c.getVille(), c.getDepartement(),
					c.isModo()));
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
		List<User> lc = userRepository.findAll();
		List<UserDto> res = new ArrayList<UserDto>();
		for (User c : lc) {
			res.add(new UserDto(c.getId(), c.getName(), c.getEmail(), c.getAge(), c.getImage(), c.getSex(), c.getVille(), c.getDepartement(),
					c.isModo()));
		}
		return res;
	}

}
