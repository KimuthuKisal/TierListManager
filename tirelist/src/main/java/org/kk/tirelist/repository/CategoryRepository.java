package org.kk.tirelist.repository;

import org.kk.tirelist.model.CategoryModel;
import org.kk.tirelist.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {
    List<CategoryModel> findByActiveFlag(boolean isActive);
}
