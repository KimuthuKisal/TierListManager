package org.kk.tirelist.repository;

import org.kk.tirelist.model.TireRowModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Set;

public interface TireRowRepository extends JpaRepository<TireRowModel, Long> {
//    List<TireRowModel> findByTierId(Long tid);
    List<TireRowModel> findAllByTireIdIn(Set<Long> tireIds);
    List<TireRowModel> findAllByTireId(Long tireId);
}
