package org.kk.tirelist.repository;

import org.kk.tirelist.model.TireRowItemModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface TireRowItemRepository extends JpaRepository<TireRowItemModel, Long> {
    List<TireRowItemModel> findAllByRowIdIn(Set<Long> rowIds);
}
