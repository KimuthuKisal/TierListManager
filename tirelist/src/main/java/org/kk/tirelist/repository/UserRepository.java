package org.kk.tirelist.repository;

import org.kk.tirelist.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    List<UserModel> findByUserAccountStatus(int userAccountStatus);
    public UserModel findByUserName(String userName);
    public UserModel findByUserEmail(String userEmail);
}
