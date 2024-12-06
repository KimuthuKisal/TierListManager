package org.kk.tirelist.service;

import org.kk.tirelist.dao.UserDao;
import org.kk.tirelist.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(@Qualifier("postgres") UserDao userDao) {
        this.userDao = userDao;
    }
    public int createUser(UserModel user) {
        return userDao.createUser(user);
    }
    public List<UserModel> getAllUsers() {
        return userDao.getAllUsers();
    }
    public Optional<UserModel> getUserById(int id) {
        return userDao.getUserById(id);
    }
    public int deleteUser(int id) {
        return userDao.deleteUser(id);
    }
    public int updateUser(int id, UserModel newUser) {
        return userDao.updateUser(id, newUser);
    }

}
