package com.youngprime.revenue.users.services;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.UriInfo;

import com.youngprime.revenue.users.cdi.UsersBean;
import com.youngprime.revenue.users.dtos.LoginParam;
import com.youngprime.revenue.users.dtos.UserDto;

public class UserServiceImpl implements UserService{

	@Inject
	UsersBean userBean;
	
	@Override
	public UserDto register(UserDto userData) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto verifyEmailAddress(String verificationCode) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean requestPasswordChange(String emailAddress) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserDto changePassword(String verificationCode, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto verifyPhoneNumber(String verificationCode, String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto login(LoginParam loginParam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> filter(UriInfo uriInfo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto update(UserDto userData) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
