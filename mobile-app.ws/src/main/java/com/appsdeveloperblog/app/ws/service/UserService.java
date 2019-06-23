package com.appsdeveloperblog.app.ws.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.appsdeveloperblog.app.ws.shared.dto.UserDto;

public interface UserService extends UserDetailsService {

	public UserDto createUser(UserDto user);

	public List<UserDto> getAllUser();

	public UserDto getUser(String email);

}
