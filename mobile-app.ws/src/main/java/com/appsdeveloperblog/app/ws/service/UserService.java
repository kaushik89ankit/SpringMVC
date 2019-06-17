package com.appsdeveloperblog.app.ws.service;

import java.util.List;

import com.appsdeveloperblog.app.ws.shared.dto.UserDto;

public interface UserService {

	public UserDto createUser(UserDto user);

	public List<UserDto> getAllUser();

}
