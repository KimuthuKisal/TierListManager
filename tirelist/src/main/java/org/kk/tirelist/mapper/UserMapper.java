package org.kk.tirelist.mapper;

import org.kk.tirelist.dto.CreateUserDto;
import org.kk.tirelist.dto.UserDto;
import org.kk.tirelist.model.UserModel;

import java.time.LocalDateTime;

public class UserMapper {
    public static UserDto mapUserToUserDto(UserModel user) {
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getUserName(),
                user.getUserEmail(),
                user.getNic(),
                user.getDob(),
                user.getContactNumber(),
                user.getAddress(),
                user.getProfileImage(),
                user.getWorkingStatus(),
                user.getUserAccountStatus(),
                user.getCreatedOn(),
                user.getDeletedOn()
        );
    }

    // public static UserModel mapUserDtoToUser(UserDto userDto) {
    //     return new UserModel(
    //         userDto.getId(),
    //         userDto.getFirstName(),
    //         userDto.getLastName(),
    //         userDto.getUserName(),
    //         userDto.getUserEmail(),
    //         userDto.getNic(),
    //         userDto.getDob(),
    //         userDto.getContactNumber(),
    //         userDto.getAddress(),
    //         userDto.getProfileImage(),
    //         userDto.getWorkingStatus(),
    //         userDto.getUserAccountStatus(),
    //         userDto.getCreatedOn(),
    //         userDto.getDeletedOn()      
    //     );
    // }

    public static UserModel mapCreateUserDtoToUser(CreateUserDto createUserDto) {
        return new UserModel(
            createUserDto.getFirstName(),
            createUserDto.getLastName(),
            createUserDto.getUserName(),
            createUserDto.getUserEmail(),
            createUserDto.getNic(),
            createUserDto.getDob(),
            createUserDto.getContactNumber(),
            createUserDto.getAddress(),
            createUserDto.getProfileImage(),
            createUserDto.getWorkingStatus(),
            UserAccountStatus.ACTIVE.ordinal(),
            LocalDateTime.now(),
            null
        );
    }

    public enum UserAccountStatus {
        INACTIVE,
        ACTIVE,
        DELETED,
        SUSPENDED
    }
}
