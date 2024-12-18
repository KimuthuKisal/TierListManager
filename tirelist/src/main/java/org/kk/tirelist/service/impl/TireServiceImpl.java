package org.kk.tirelist.service.impl;

import org.kk.tirelist.dto.tire.CreateTireDto;
import org.kk.tirelist.dto.tire.TireDto;
import org.kk.tirelist.dto.tire.TireRowDto;
import org.kk.tirelist.dto.tire.TireRowItemDto;
import org.kk.tirelist.mapper.TireMapper;
import org.kk.tirelist.model.TireListModel;
import org.kk.tirelist.model.TireRowItemModel;
import org.kk.tirelist.model.TireRowModel;
import org.kk.tirelist.repository.TireRepository;
import org.kk.tirelist.repository.TireRowItemRepository;
import org.kk.tirelist.repository.TireRowRepository;
import org.kk.tirelist.service.TireService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TireServiceImpl implements TireService {
    private final TireRepository tireRepository;
    private final TireRowRepository tireRowRepository;
    private final TireRowItemRepository tireRowItemRepository;
//    private final TireMapper tireMapper;

    public TireServiceImpl(TireRepository tireRepository, TireRowRepository tireRowRepository, TireRowItemRepository tireRowItemRepository) {
        this.tireRepository = tireRepository;
        this.tireRowRepository = tireRowRepository;
//        this.tireMapper = tireMapper;
        this.tireRowItemRepository = tireRowItemRepository;
    }

    @Override
    public TireDto createTire(CreateTireDto createTireDto) {
        TireListModel tire = TireMapper.mapCreateTireDtoToTire(createTireDto);
        TireListModel savedTier = tireRepository.save(tire);
        int rowCountForTire = savedTier.getRowCount();
        for (int i = 1; i <= rowCountForTire; i++) {
            TireRowModel row = new TireRowModel(savedTier.getId(), i, i);
            tireRowRepository.save(row);
        }
        List<TireRowModel> rows = tireRowRepository.findAllByTireId(savedTier.getId());
        List<TireRowItemModel> allItems = tireRowItemRepository.findAllByRowIdIn(
                rows.stream().map(TireRowModel::getId).collect(Collectors.toSet()));
        List<TireRowDto> rowDtos = rows.stream()
                .map(row -> {
                    List<TireRowItemDto> rowItems = allItems.stream()
                            .filter(item -> item.getRowId().equals(row.getId())) // Ensure correct filtering
                            .map(item -> TireMapper.mapTireRowIremToTireRowItemDto(item))
                            .collect(Collectors.toList());
                    return TireMapper.mapTireRowToTireRowDto(row, rowItems); // Now passing items directly
                })
                .collect(Collectors.toList());
        return TireMapper.mapTireToTireDto(savedTier, rowDtos);
    }

    @Override
    public List<TireDto> getAllTires() {
        List<TireListModel> tires = tireRepository.findAll();
        Set<Long> allTireIds = tires.stream()
                .map(TireListModel::getId)
                .collect(Collectors.toSet());
        List<TireRowModel> allRows = tireRowRepository.findAllByTireIdIn(allTireIds);
        List<TireRowItemModel> allItems = tireRowItemRepository.findAllByRowIdIn(allRows.stream().map(TireRowModel::getId).collect(Collectors.toSet()));
        List<TireRowDto> rowDtos = allRows.stream()
                .map(row -> {
                    // Find items for the current row
                    List<TireRowItemDto> rowItems = allItems.stream()
                            .filter(item -> item.getRowId().equals(row.getId()))
                            .map(item -> TireMapper.mapTireRowIremToTireRowItemDto(item))
                            .collect(Collectors.toList());
                    return TireMapper.mapTireRowToTireRowDto(row, rowItems);
                })
                .collect(Collectors.toList());
        List<TireDto> tireDtos = tires.stream()
                .map(tire -> {
                    List<TireRowDto> filteredRows = rowDtos.stream()
                            .filter(row -> row.getTireId().equals(tire.getId()))
                            .collect(Collectors.toList());
                    return TireMapper.mapTireToTireDto(tire, filteredRows);
                })
                .collect(Collectors.toList());
        return tireDtos;
    }
}
