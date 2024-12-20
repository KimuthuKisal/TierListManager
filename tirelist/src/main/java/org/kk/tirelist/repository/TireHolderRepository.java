package org.kk.tirelist.repository;

import org.kk.tirelist.model.TireHolderModel;
import org.kk.tirelist.model.TireRowItemModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface TireHolderRepository extends JpaRepository<TireHolderModel, Long> {
    TireHolderModel findByTireIdAndItemId(Long tid, Long iid);
    TireHolderModel findByTireId(Long tid);
    List<TireHolderModel> findAllByTireIdIn(Set<Long> rowIds);
    List<TireHolderModel> findAllByTireId(Long rowId);
}
