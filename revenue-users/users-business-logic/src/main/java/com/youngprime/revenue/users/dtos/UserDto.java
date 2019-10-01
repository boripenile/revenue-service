package com.youngprime.revenue.users.dtos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserDto {

public String id;
	
	@NotEmpty
	@Size(min=6, max=50, message="Username must be between 6 and 50 characters")
	public String username = null;
	
	@NotEmpty
	@Size(min=6, max=50, message="Password must be between 6 and 50 characters")
	public String password = null;
	
	@NotEmpty
	@Email
	public String emailAddress = null;
	
	@NotEmpty
	@Size(min=6, max=50, message="First name must be between 6 and 50 characters")
	public String firstName = null;
	
	@NotEmpty
	@Size(min=6, max=50, message="Last name must be between 6 and 50 characters")
	public String lastName = null;
	
	public String otherName = null;
	
	public String imageUrl = null;
	
	public boolean emailVerified;
	
	public boolean phoneVerified;
	
	public String emailVerifiedDate = null;
	
	public String phoneVerifiedDate = null;
	
	public String resetPasswordRequestDate = null;
	
	public String resetPasswordDate = null;
	
	public String verificationExpiredDate = null;
	
	public String createdAt = null;
	
	public String updatedAt = null;
	
	public boolean deleted;
	
	public boolean active;
	
	public String createdBy = null;
	
	public String updatedBy = null;
	
	public List<RoleDto> roles = new ArrayList<>();
	
	public List<PermissionDto> permissions = new ArrayList<>();

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", username=" + username + ", password=" + password + ", emailAddress="
				+ emailAddress + ", firstName=" + firstName + ", lastName=" + lastName + ", otherName=" + otherName
				+ ", imageUrl=" + imageUrl + ", emailVerified=" + emailVerified + ", phoneVerified=" + phoneVerified
				+ ", emailVerifiedDate=" + emailVerifiedDate + ", phoneVerifiedDate=" + phoneVerifiedDate
				+ ", resetPasswordRequestDate=" + resetPasswordRequestDate + ", resetPasswordDate=" + resetPasswordDate
				+ ", verificationExpiredDate=" + verificationExpiredDate + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + ", deleted=" + deleted + ", active=" + active + ", createdBy=" + createdBy
				+ ", updatedBy=" + updatedBy + ", roles=" + roles + ", permissions=" + permissions + "]";
	}
	
}
