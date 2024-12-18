package org.kk.tirelist.repository;

import org.kk.tirelist.model.TireListModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TireRepository extends JpaRepository<TireListModel, Long> {
}
