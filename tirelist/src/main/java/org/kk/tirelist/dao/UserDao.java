package org.kk.tirelist.dao;

import org.kk.tirelist.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    int createUser(UserModel user);
    List<UserModel> getAllUsers();
    Optional<UserModel> getUserById(int id);
    int deleteUser(int id);
    int updateUser(int id, UserModel newUser);
}
