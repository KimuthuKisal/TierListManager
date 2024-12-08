package org.kk.tirelist.repository;

import org.kk.tirelist.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    List<UserModel> findByUserAccountStatus(int userAccountStatus);
}
