package org.kk.tirelist.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.kk.tirelist.dto.Item.ItemDto;
import org.kk.tirelist.dto.tire.*;
import org.kk.tirelist.mapper.ItemMapper;
import org.kk.tirelist.mapper.TireMapper;
import org.kk.tirelist.model.*;
import org.kk.tirelist.repository.*;
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
    private final TireHolderRepository tireHolderRepository;
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
//    private final TireMapper tireMapper;

    public TireServiceImpl(TireRepository tireRepository, TireRowRepository tireRowRepository, TireRowItemRepository tireRowItemRepository, TireHolderRepository tireHolderRepository, ItemRepository itemRepository, ItemMapper itemMapper) {
        this.tireRepository = tireRepository;
        this.tireRowRepository = tireRowRepository;
//        this.tireMapper = tireMapper;
        this.tireRowItemRepository = tireRowItemRepository;
        this.tireHolderRepository = tireHolderRepository;
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
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
//        List<TireRowModel> rows = tireRowRepository.findAllByTireId(savedTier.getId());
//        List<TireRowItemModel> allItems = tireRowItemRepository.findAllByRowIdIn(rows.stream().map(TireRowModel::getId).collect(Collectors.toSet()));
//        List<TireRowDto> rowDtos = rows.stream()
//                .map(row -> {
//                    List<TireRowItemDto> rowItems = allItems.stream()
//                            .filter(item -> item.getRowId().equals(row.getId())) // Ensure correct filtering
//                            .map(TireMapper::mapTireRowIremToTireRowItemDto)
//                            .collect(Collectors.toList());
//                    return TireMapper.mapTireRowToTireRowDto(row, rowItems); // Now passing items directly
//                })
//                .collect(Collectors.toList());
        return this.getTireById(savedTier.getId());
    }

    @Override
    public List<TireDto> getAllTires() {
        // Get all Tires and tire IDs
        List<TireListModel> tires = tireRepository.findAll();
        Set<Long> allTireIds = tires.stream()
                .map(TireListModel::getId)
                .collect(Collectors.toSet());  // Ensure uniqueness

        // Get all Rows related to TireIds
        List<TireRowModel> allRows = tireRowRepository.findAllByTireIdIn(allTireIds);

        // Get all Holders related to TireIds
        List<TireHolderModel> allHolders = tireHolderRepository.findAllByTireIdIn(allTireIds);

        // Get all Row Ids into a set -> using this set get row items
        List<TireRowItemModel> allItems = tireRowItemRepository.findAllByRowIdIn(allRows.stream()
                .map(TireRowModel::getId)
                .collect(Collectors.toSet()));

        // Map Rows into RowDtos
        List<TireRowDto> rowDtos = allRows.stream()
                .map(row -> {
                    // Find items for the current row
                    List<TireRowItemDto> rowItems = allItems.stream()
                            .filter(item -> item.getRowId().equals(row.getId()))
                            .map(item -> {
                                // Map each TireRowItemModel to TireRowItemDto with the corresponding ItemDto
                                ItemDto itemDto = itemMapper.mapItemToItemDto(itemRepository.findById(item.getItemId()).orElseThrow(() -> new EntityNotFoundException("Item not found with id: " + item.getItemId()))); // Adjust this based on how ItemDto is created
                                return TireMapper.mapTireRowItemToTireRowItemDto(item, itemDto);
                            })
                            .collect(Collectors.toList());
                    return TireMapper.mapTireRowToTireRowDto(row, rowItems); // Map row to TireRowDto with the items
                })
                .toList();

        // Map Holders into HolderItemDtos
        List<TireHolderDto> holderItemDtos = allHolders.stream()
                .map(holder -> {
                    // Assuming ItemModel is directly related to TireHolderModel
                    ItemDto itemDto = itemMapper.mapItemToItemDto(itemRepository.findById(holder.getItemId()).orElseThrow(() -> new EntityNotFoundException("Item not found with id: " + holder.getItemId())));
                    return new TireHolderDto(holder.getId(), holder.getTireId(), itemDto);
                })
                .toList();

        // Filter relevant Dtos for each Tire
        return tires.stream()
                .map(tire -> {
                    // Filter rows related to the current tire
                    List<TireRowDto> filteredRows = rowDtos.stream()
                            .filter(row -> row.getTireId().equals(tire.getId()))
                            .collect(Collectors.toList());
                    // Filter holders related to the current tire
                    List<TireHolderDto> filteredHolders = holderItemDtos.stream()
                            .filter(holderItem -> holderItem.getTireId().equals(tire.getId()))
                            .collect(Collectors.toList());
                    // Map tire to DTO with filtered rows and holders
                    return TireMapper.mapTireToTireDto(tire, filteredRows, filteredHolders);
                })
                .collect(Collectors.toList());
    }

    @Override
    public TireDto getTireById(Long tid) {
        // Get the Tire
        TireListModel tire = tireRepository.findById(tid)
                .orElseThrow(() -> new EntityNotFoundException("Tire not found with id: " + tid));

        // Get all Rows associated with the Tire
        List<TireRowModel> rows = tireRowRepository.findAllByTireId(tid);

        // Get all HolderItems associated with the Tire
        List<TireHolderModel> holderItems = tireHolderRepository.findAllByTireId(tid);

        // Get all Row Items associated with Rows of the Tire
        Set<Long> rowIds = rows.stream().map(TireRowModel::getId).collect(Collectors.toSet());
        List<TireRowItemModel> items = tireRowItemRepository.findAllByRowIdIn(rowIds);

        // Map Rows to RowDtos, mapping each Row to its corresponding TireRowItemDto
        List<TireRowDto> rowDtos = rows.stream()
                .map(row -> {
                    // Find items for the current row
                    List<TireRowItemDto> rowItems = items.stream()
                            .filter(item -> item.getRowId().equals(row.getId()))
                            .map(item -> {
                                // Map each TireRowItemModel to TireRowItemDto with the corresponding ItemDto
                                ItemDto itemDto = itemMapper.mapItemToItemDto(
                                        itemRepository.findById(item.getItemId())
                                                .orElseThrow(() -> new EntityNotFoundException("Item not found with id: " + item.getItemId()))
                                );
                                return TireMapper.mapTireRowItemToTireRowItemDto(item, itemDto);
                            })
                            .collect(Collectors.toList());
                    return TireMapper.mapTireRowToTireRowDto(row, rowItems); // Map the RowDto with the items
                })
                .collect(Collectors.toList());

        // Map HolderItems to HolderItemDtos
        List<TireHolderDto> holderItemDtos = holderItems.stream()
                .map(holder -> {
                    ItemDto itemDto = itemMapper.mapItemToItemDto(
                            itemRepository.findById(holder.getItemId())
                                    .orElseThrow(() -> new EntityNotFoundException("Item not found with id: " + holder.getItemId()))
                    );
                    return new TireHolderDto(holder.getId(), holder.getTireId(), itemDto);
                })
                .collect(Collectors.toList());

        return TireMapper.mapTireToTireDto(tire, rowDtos, holderItemDtos);
    }


    @Override
    public TireDto addItemToRow(Long rid, Long iid) {
        TireRowItemModel addItemToRow = new TireRowItemModel(rid, iid);
        tireRowItemRepository.save(addItemToRow);
        TireRowModel itemAddedRow = tireRowRepository.findById(rid).orElseThrow(() -> new EntityNotFoundException("Row not found with id: " + rid));
        return this.getTireById(itemAddedRow.getTireId());
    }

    @Override
    public TireDto removeItemFromRow(Long rid, Long iid) {
        TireRowItemModel deleteRowItem = tireRowItemRepository.findByRowIdAndItemId(rid, iid);
        tireRowItemRepository.delete(deleteRowItem);
        TireRowModel itemRemovedRow = tireRowRepository.findById(rid).orElseThrow(() -> new EntityNotFoundException("Row not found with id: " + rid));
        return this.getTireById(itemRemovedRow.getTireId());
    }

    @Override
    public TireDto addItemToHolder(Long tid, Long iid) {
        TireHolderModel addHolderItem = new TireHolderModel(tid, iid);
        tireHolderRepository.save(addHolderItem);
        return this.getTireById(tid);
    }

    @Override
    public TireDto removeItemFromHolder(Long tid, Long iid) {
        TireHolderModel deleteHolderItem = tireHolderRepository.findByTireIdAndItemId(tid, iid);
        tireHolderRepository.delete(deleteHolderItem);
        return this.getTireById(tid);
    }


}
