package org.kk.tirelist.service.impl;

import org.kk.tirelist.dto.UserModel.CreateUserDto;
import org.kk.tirelist.dto.UserModel.UserDto;
import org.kk.tirelist.exception.ResourceNotFoundException;
import org.kk.tirelist.mapper.UserMapper;
import org.kk.tirelist.model.UserModel;
import org.kk.tirelist.repository.UserRepository;
import org.kk.tirelist.service.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return User.withUsername(user.getUserName()).password(user.getPassword()).roles(user.getRole()).build();
    }

    public enum UserAccountStatus {
        INACTIVE,
        ACTIVE,
        DELETED,
        SUSPENDED
    }
    @Override
    public UserDto createUser(CreateUserDto createUserDto) {
        UserModel user = UserMapper.mapCreateUserDtoToUser(createUserDto);
        UserModel savedUser = userRepository.save(user);
        return UserMapper.mapUserToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {
        UserModel user = userRepository.findById(userId).orElseThrow( ()-> new ResourceNotFoundException("User not found with given id " + userId));
        return UserMapper.mapUserToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserModel> users = userRepository.findAll();
        return users.stream().map(UserMapper::mapUserToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long userId, UserDto updateUserDto) {
        UserModel user = userRepository.findById(userId).orElseThrow( ()-> new ResourceNotFoundException("User not found with given id " + userId));
        user.setFirstName(updateUserDto.getFirstName());
        user.setLastName(updateUserDto.getLastName());
        user.setUserName(updateUserDto.getUserName());
        user.setUserEmail(updateUserDto.getUserEmail());
        user.setNic(updateUserDto.getNic());
        user.setDob(updateUserDto.getDob());
        user.setContactNumber(updateUserDto.getContactNumber());
        user.setAddress(updateUserDto.getAddress());
        user.setProfileImage(updateUserDto.getProfileImage());
        user.setWorkingStatus(updateUserDto.getWorkingStatus());
//        user.setUserAccountStatus(updateUserDto.getUserAccountStatus());
//        user.setCreatedOn(updateUserDto.getCreatedOn());
//        user.setDeletedOn(updateUserDto.getDeletedOn());
        UserModel updatedUser = userRepository.save(user);
        return UserMapper.mapUserToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        UserModel user = userRepository.findById((userId)).orElseThrow( ()-> new ResourceNotFoundException("User not found with given id " + userId));
        user.setUserAccountStatus(UserAccountStatus.DELETED.ordinal());
        user.setDeletedOn(LocalDateTime.now());
        userRepository.save(user);
    }

    @Override
    public void deactivateUser(Long userId) {
        UserModel user = userRepository.findById((userId)).orElseThrow( ()-> new ResourceNotFoundException("User not found with given id " + userId));
        user.setUserAccountStatus(UserAccountStatus.INACTIVE.ordinal());
        user.setDeletedOn(LocalDateTime.now());
        userRepository.save(user);
    }

    @Override
    public void suspendUser(Long userId) {
        UserModel user = userRepository.findById((userId)).orElseThrow( ()-> new ResourceNotFoundException("User not found with given id " + userId));
        user.setUserAccountStatus(UserAccountStatus.SUSPENDED.ordinal());
        user.setDeletedOn(LocalDateTime.now());
        userRepository.save(user);
    }

    @Override
    public void reactivateUser(Long userId) {
        UserModel user = userRepository.findById((userId)).orElseThrow( ()-> new ResourceNotFoundException("User not found with given id " + userId));
        user.setUserAccountStatus(UserAccountStatus.ACTIVE.ordinal());
        user.setDeletedOn(LocalDateTime.now());
        userRepository.save(user);
    }

    @Override
    public List<UserDto> findByUserAccountStatus(int accountStatus) {
        List<UserModel> users = userRepository.findByUserAccountStatus(accountStatus);
        return users.stream().map(UserMapper::mapUserToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDetails findByUserName(String userName) throws UsernameNotFoundException {
        UserModel currUser = userRepository.findByUserName(userName);
        if (currUser != null) {
            var springUser = User.withUsername(currUser.getUserName()).password(currUser.getPassword()).roles(currUser.getRole()).build();
            return springUser;
        }
        return null;
    }

    @Override
    public UserDetails findByUserEmail(String userEmail) {
        UserModel currUser = userRepository.findByUserEmail(userEmail);
        if (currUser != null) {
            var springUser = User.withUsername(currUser.getUserName()).password(currUser.getPassword()).roles(currUser.getRole()).build();
            return springUser;
        }
        return null;
    }


}