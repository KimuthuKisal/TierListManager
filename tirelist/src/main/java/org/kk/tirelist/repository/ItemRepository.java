package org.kk.tirelist.repository;

import org.kk.tirelist.model.CategoryModel;
import org.kk.tirelist.model.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<ItemModel, Long> {
    List<ItemModel> findByIsActive(boolean isActive);
    List<ItemModel> findByCategory(Long cid);
}
