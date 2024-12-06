package org.kk.tirelist.repository;

import org.kk.tirelist.dao.UserDao;
import org.kk.tirelist.model.UserModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("postgres")
public class UserDataAccessRepository implements UserDao {
    @Override
    public int createUser(UserModel user) {
        return 0;
    }
    @Override
    public List<UserModel> getAllUsers() {
        return null;
    }
    @Override
    public Optional<UserModel> getUserById(int id) {
        return Optional.empty();
    }
    @Override
    public int deleteUser(int id) {
        return 0;
    }
    @Override
    public int updateUser(int id, UserModel newUser) {
        return 0;
    }
}
