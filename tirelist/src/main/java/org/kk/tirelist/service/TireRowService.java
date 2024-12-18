package org.kk.tirelist.service;

import java.util.List;
import org.kk.tirelist.dto.tire.TireRowDto;

public interface TireRowService {
    List<TireRowDto> getRowsById(Long tid);
}
