package com.youngprime.revenue.users.mappers;

import com.youngprime.revenue.users.Permissions;
import com.youngprime.revenue.users.Roles;
import com.youngprime.revenue.users.Users;
import com.youngprime.revenue.users.dtos.PermissionDto;
import com.youngprime.revenue.users.dtos.RoleDto;
import com.youngprime.revenue.users.dtos.UserDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-01T01:34:37+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
@ApplicationScoped
public class UserMapperImpl implements UserMapper {

    @Inject
    private DateMapper dateMapper;

    @Override
    public UserDto fromUser(Users user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.id = user.getId();
        userDto.username = user.getUsername();
        userDto.password = user.getPassword();
        userDto.emailAddress = user.getEmailAddress();
        userDto.firstName = user.getFirstName();
        userDto.lastName = user.getLastName();
        userDto.otherName = user.getOtherName();
        userDto.imageUrl = user.getImageUrl();
        userDto.emailVerified = user.isEmailVerified();
        userDto.phoneVerified = user.isPhoneVerified();
        userDto.emailVerifiedDate = dateMapper.asString( user.getEmailVerifiedDate() );
        userDto.phoneVerifiedDate = dateMapper.asString( user.getPhoneVerifiedDate() );
        userDto.resetPasswordRequestDate = dateMapper.asString( user.getResetPasswordRequestDate() );
        userDto.resetPasswordDate = dateMapper.asString( user.getResetPasswordDate() );
        userDto.verificationExpiredDate = dateMapper.asString( user.getVerificationExpiredDate() );
        userDto.createdAt = dateMapper.asString( user.getCreatedAt() );
        userDto.updatedAt = dateMapper.asString( user.getUpdatedAt() );
        userDto.deleted = user.isDeleted();
        userDto.active = user.isActive();
        userDto.createdBy = user.getCreatedBy();
        userDto.updatedBy = user.getUpdatedBy();
        userDto.roles = fromRoles( user.getRoles() );
        userDto.permissions = fromPermissions( user.getPermissions() );

        return userDto;
    }

    @Override
    public Users toUser(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        Users users = new Users();

        users.setId( dto.id );
        users.setUsername( dto.username );
        users.setPassword( dto.password );
        users.setEmailAddress( dto.emailAddress );
        users.setFirstName( dto.firstName );
        users.setLastName( dto.lastName );
        users.setOtherName( dto.otherName );
        users.setImageUrl( dto.imageUrl );
        users.setEmailVerified( dto.emailVerified );
        users.setPhoneVerified( dto.phoneVerified );
        users.setEmailVerifiedDate( dateMapper.asDate( dto.emailVerifiedDate ) );
        users.setPhoneVerifiedDate( dateMapper.asDate( dto.phoneVerifiedDate ) );
        users.setResetPasswordRequestDate( dateMapper.asDate( dto.resetPasswordRequestDate ) );
        users.setResetPasswordDate( dateMapper.asDate( dto.resetPasswordDate ) );
        users.setVerificationExpiredDate( dateMapper.asDate( dto.verificationExpiredDate ) );
        users.setCreatedAt( dateMapper.asDate( dto.createdAt ) );
        users.setUpdatedAt( dateMapper.asDate( dto.updatedAt ) );
        users.setDeleted( dto.deleted );
        users.setActive( dto.active );
        users.setCreatedBy( dto.createdBy );
        users.setUpdatedBy( dto.updatedBy );
        users.setRoles( roleDtoListToRolesList( dto.roles ) );
        users.setPermissions( permissionDtoListToPermissionsList( dto.permissions ) );

        return users;
    }

    @Override
    public List<RoleDto> fromRoles(List<Roles> roles) {
        if ( roles == null ) {
            return null;
        }

        List<RoleDto> list = new ArrayList<RoleDto>( roles.size() );
        for ( Roles roles1 : roles ) {
            list.add( rolesToRoleDto( roles1 ) );
        }

        return list;
    }

    @Override
    public List<PermissionDto> fromPermissions(List<Permissions> permissions) {
        if ( permissions == null ) {
            return null;
        }

        List<PermissionDto> list = new ArrayList<PermissionDto>( permissions.size() );
        for ( Permissions permissions1 : permissions ) {
            list.add( permissionsToPermissionDto( permissions1 ) );
        }

        return list;
    }

    protected Roles roleDtoToRoles(RoleDto roleDto) {
        if ( roleDto == null ) {
            return null;
        }

        Roles roles = new Roles();

        roles.setId( roleDto.id );
        roles.setRoleName( roleDto.roleName );
        roles.setDescription( roleDto.description );
        roles.setCreatedAt( dateMapper.asDate( roleDto.createdAt ) );
        roles.setUpdatedAt( dateMapper.asDate( roleDto.updatedAt ) );
        roles.setDeleted( roleDto.deleted );
        roles.setActive( roleDto.active );
        roles.setCreatedBy( roleDto.createdBy );
        roles.setUpdatedBy( roleDto.updatedBy );

        return roles;
    }

    protected List<Roles> roleDtoListToRolesList(List<RoleDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Roles> list1 = new ArrayList<Roles>( list.size() );
        for ( RoleDto roleDto : list ) {
            list1.add( roleDtoToRoles( roleDto ) );
        }

        return list1;
    }

    protected Permissions permissionDtoToPermissions(PermissionDto permissionDto) {
        if ( permissionDto == null ) {
            return null;
        }

        Permissions permissions = new Permissions();

        permissions.setId( permissionDto.id );
        permissions.setPermission( permissionDto.permission );
        permissions.setDescription( permissionDto.description );
        permissions.setCreatedAt( dateMapper.asDate( permissionDto.createdAt ) );
        permissions.setUpdatedAt( dateMapper.asDate( permissionDto.updatedAt ) );
        permissions.setDeleted( permissionDto.deleted );
        permissions.setActive( permissionDto.active );
        permissions.setCreatedBy( permissionDto.createdBy );
        permissions.setUpdatedBy( permissionDto.updatedBy );

        return permissions;
    }

    protected List<Permissions> permissionDtoListToPermissionsList(List<PermissionDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Permissions> list1 = new ArrayList<Permissions>( list.size() );
        for ( PermissionDto permissionDto : list ) {
            list1.add( permissionDtoToPermissions( permissionDto ) );
        }

        return list1;
    }

    protected RoleDto rolesToRoleDto(Roles roles) {
        if ( roles == null ) {
            return null;
        }

        RoleDto roleDto = new RoleDto();

        roleDto.id = roles.getId();
        roleDto.roleName = roles.getRoleName();
        roleDto.description = roles.getDescription();
        roleDto.createdAt = dateMapper.asString( roles.getCreatedAt() );
        roleDto.updatedAt = dateMapper.asString( roles.getUpdatedAt() );
        roleDto.deleted = roles.isDeleted();
        roleDto.active = roles.isActive();
        roleDto.createdBy = roles.getCreatedBy();
        roleDto.updatedBy = roles.getUpdatedBy();

        return roleDto;
    }

    protected PermissionDto permissionsToPermissionDto(Permissions permissions) {
        if ( permissions == null ) {
            return null;
        }

        PermissionDto permissionDto = new PermissionDto();

        permissionDto.id = permissions.getId();
        permissionDto.permission = permissions.getPermission();
        permissionDto.description = permissions.getDescription();
        permissionDto.createdAt = dateMapper.asString( permissions.getCreatedAt() );
        permissionDto.updatedAt = dateMapper.asString( permissions.getUpdatedAt() );
        permissionDto.deleted = permissions.isDeleted();
        permissionDto.active = permissions.isActive();
        permissionDto.createdBy = permissions.getCreatedBy();
        permissionDto.updatedBy = permissions.getUpdatedBy();

        return permissionDto;
    }
}
