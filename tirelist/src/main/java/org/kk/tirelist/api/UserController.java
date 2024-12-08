package org.kk.tirelist.api;

import org.apache.catalina.User;
import org.apache.coyote.Response;
import org.kk.tirelist.dto.CreateUserDto;
import org.kk.tirelist.dto.UserDto;
import org.kk.tirelist.model.UserModel;
import org.kk.tirelist.repository.UserRepository;
import org.kk.tirelist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/user")
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    public enum UserAccountStatus {
        INACTIVE,
        ACTIVE,
        DELETED,
        SUSPENDED
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@Validated @NonNull @RequestBody CreateUserDto createUserDto) {
        UserDto savedUser = userService.createUser(createUserDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    @GetMapping("{uid}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("uid") Long uid) {
        UserDto userDto = userService.getUserById(uid);
        return ResponseEntity.ok(userDto);
    }
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    @GetMapping("active")
    public ResponseEntity<List<UserDto>> getAllActiveUsers() {
        List<UserDto> users = userService.findByUserAccountStatus(UserAccountStatus.ACTIVE.ordinal());
        return ResponseEntity.ok(users);
    }
    @GetMapping("deactive")
    public ResponseEntity<List<UserDto>> getAllDeactiveUsers() {
        List<UserDto> users = userService.findByUserAccountStatus(UserAccountStatus.INACTIVE.ordinal());
        return ResponseEntity.ok(users);
    }
    @GetMapping("suspend")
    public ResponseEntity<List<UserDto>> getAllSuspendUsers() {
        List<UserDto> users = userService.findByUserAccountStatus(UserAccountStatus.SUSPENDED.ordinal());
        return ResponseEntity.ok(users);
    }
    @GetMapping("delete")
    public ResponseEntity<List<UserDto>> getAllDeletedUsers() {
        List<UserDto> users = userService.findByUserAccountStatus(UserAccountStatus.DELETED.ordinal());
        return ResponseEntity.ok(users);
    }
    @PutMapping("{uid}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("uid") Long uid, @RequestBody UserDto updateUserDto) {
        UserDto userDto = userService.updateUser(uid, updateUserDto);
        return ResponseEntity.ok(userDto);
    }
    @DeleteMapping("{uid}")
    public ResponseEntity<String> deleteUser(@PathVariable("uid") Long uid) {
        userService.deleteUser(uid);
        return ResponseEntity.ok("User Account deleted successfully");
    }
    @PutMapping("deactive/{uid}")
    public ResponseEntity<String> deactivateUser(@PathVariable("uid") Long uid) {
        userService.deactivateUser(uid);
        return ResponseEntity.ok("User Account deactivated successfully");
    }
    @PutMapping("suspend/{uid}")
    public ResponseEntity<String> suspendUser(@PathVariable("uid") Long uid) {
        userService.suspendUser(uid);
        return ResponseEntity.ok("User Account suspended successfully");
    }
    @PutMapping("activate/{uid}")
    public ResponseEntity<String> activateUser(@PathVariable("uid") Long uid) {
        userService.reactivateUser(uid);
        return ResponseEntity.ok("User Account activated successfully");
    }

}
