package com.youngprime.revenue.users.services;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.UriInfo;

import com.youngprime.revenue.users.dtos.LoginParam;
import com.youngprime.revenue.users.dtos.UserDto;

@RequestScoped
public interface UserService {

	public List<UserDto> filter(UriInfo uriInfo) throws Exception;
	
	public List<UserDto> list() throws Exception;
	
	public UserDto update(UserDto userData) throws Exception;
	
	public UserDto register(UserDto userData) throws Exception;
	
	public UserDto verifyEmailAddress(String verificationCode) throws Exception;
	
	public boolean requestPasswordChange(String emailAddress);
	
	public UserDto changePassword(String verificationCode, String newPassword);
	
	public UserDto verifyPhoneNumber(String verificationCode, String phoneNumber);
	
	public UserDto login(LoginParam loginParam);
	
}
