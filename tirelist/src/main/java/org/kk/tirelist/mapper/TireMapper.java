package org.kk.tirelist.mapper;

import java.time.LocalDateTime;
import java.util.List;

import org.kk.tirelist.dto.tire.CreateTireDto;
import org.kk.tirelist.dto.tire.TireDto;
import org.kk.tirelist.dto.tire.TireRowDto;
import org.kk.tirelist.dto.tire.TireRowItemDto;
import org.kk.tirelist.model.TireListModel;
import org.kk.tirelist.model.TireRowItemModel;
import org.kk.tirelist.model.TireRowModel;

public class TireMapper {
    public static TireDto mapTireToTireDto(TireListModel tireListModel, List<TireRowDto> rows) {
        return new TireDto(
            tireListModel.getId(),
            tireListModel.getTireName(),
            tireListModel.getDescription(),
            tireListModel.getCreatedBy(),
            tireListModel.getCreatedOn(),
            tireListModel.getUpdatedOn(),
            tireListModel.getVisibility(),
            tireListModel.getRowCount(),
            tireListModel.getRowCapacity(),
            tireListModel.getHolderCapacity(), rows);
    }

    public static TireListModel mapCreateTireDtoToTire(CreateTireDto createTireDto) {
        return new TireListModel(
            createTireDto.getTireName(),
            createTireDto.getDescription(),
            createTireDto.getCreatedBy(),
            LocalDateTime.now(),
            createTireDto.getVisibility(),
            createTireDto.getRowCount(),
            createTireDto.getRowCapacity(),
            createTireDto.getHolderCapacity());
    }

    public static TireRowDto mapTireRowToTireRowDto(TireRowModel row, List<TireRowItemDto> items) {
        return new TireRowDto(
            row.getId(),
            row.getTireId(),
            row.getRowNumber(),
            row.getPosition(),
            items);
    }

    public static TireRowItemDto mapTireRowIremToTireRowItemDto(TireRowItemModel rowItem) {
        return new TireRowItemDto(
            rowItem.getId(),
            rowItem.getRowId(), 
            rowItem.getItemId()
        );
    }

    // tier with user and items

    // tire with user, items and votes and comments
}
