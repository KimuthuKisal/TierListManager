package org.kk.tirelist.service;
import org.kk.tirelist.dto.CreateUserDto;
import org.kk.tirelist.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(CreateUserDto userDto);
    UserDto getUserById(Long userId);
    List<UserDto> getAllUsers();
    UserDto updateUser(Long userId, UserDto updateUserDto);
    void deleteUser(Long userId);
    void deactivateUser(Long userId);
    void suspendUser(Long userId);
    void reactivateUser(Long userId);
    List<UserDto> findByUserAccountStatus(int accountStatus);
}
