package com.appsdeveloperblog.app.ws.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.appsdeveloperblog.app.ws.UserRepository;
import com.appsdeveloperblog.app.ws.io.entity.UserEntity;
import com.appsdeveloperblog.app.ws.service.UserService;
import com.appsdeveloperblog.app.ws.shared.Utils;
import com.appsdeveloperblog.app.ws.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	Utils utils;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDto createUser(UserDto user) {
		
		
		if(userRepository.findByEmail(user.getEmail()) != null) throw new RuntimeException("Record already exists");
		
		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		
		String publicUserId = utils.generateUserID(30);
		
		userEntity.setEncryptedPassword(user.getPassword());
		
		userEntity.setUserId(publicUserId);
		
		UserEntity storedUserEntity = userRepository.save(userEntity);

		UserDto returnValue = new UserDto();

		BeanUtils.copyProperties(storedUserEntity, returnValue);

		return returnValue;
	}
	
	@Override
	public List<UserDto> getAllUser() {
		List<UserEntity> allUserEntity = userRepository.findAll();
		List<UserDto> allUserDto = new ArrayList<>();

		for (UserEntity entity : allUserEntity) {
			UserDto tempUserDto = new UserDto();
			BeanUtils.copyProperties(entity, tempUserDto);
			allUserDto.add(tempUserDto);
		}

		return allUserDto;

	}

}
