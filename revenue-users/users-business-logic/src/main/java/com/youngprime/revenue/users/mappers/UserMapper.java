package com.youngprime.revenue.users.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.youngprime.revenue.users.Permissions;
import com.youngprime.revenue.users.Roles;
import com.youngprime.revenue.users.Users;
import com.youngprime.revenue.users.dtos.PermissionDto;
import com.youngprime.revenue.users.dtos.RoleDto;
import com.youngprime.revenue.users.dtos.UserDto;

@Mapper(componentModel="cdi", uses = DateMapper.class)
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	UserDto fromUser(Users user);
	
	Users toUser(UserDto dto);
	
	List<UserDto> fromUsers(List<Users> users);
	
	List<RoleDto> fromRoles(List<Roles> roles);
	
	List<PermissionDto> fromPermissions(List<Permissions> permissions);
	
}
