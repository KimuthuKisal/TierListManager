package org.kk.tirelist.mapper;

import java.time.LocalDateTime;

import org.kk.tirelist.dto.tire.CreateTireDto;
import org.kk.tirelist.dto.tire.TireDto;
import org.kk.tirelist.model.TireListModel;

public class TireMapper {
    public static TireDto mapTireToTireDto(TireListModel tireListModel) {
        return new TireDto(
            tireListModel.getId(),
            tireListModel.getTireName(),
            tireListModel.getDescription(),
            tireListModel.getCreatedBy(),
            tireListModel.getCreatedOn(),
            tireListModel.getUpdatedOn(),
            tireListModel.getVisibility()
        );
    }

    public static TireListModel mapCreateTireDtoToTire(CreateTireDto createTireDto) {
        return new TireListModel(
            createTireDto.getTireName(),
            createTireDto.getDescription(),
            createTireDto.getCreatedBy(),
            LocalDateTime.now(),
            createTireDto.getVisibility()
        );
    }
}
