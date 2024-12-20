package org.kk.tirelist.api;

import org.kk.tirelist.dto.tire.CreateTireDto;
import org.kk.tirelist.dto.tire.TireDto;
import org.kk.tirelist.service.TireService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.lang.NonNull;

import java.util.List;

@RequestMapping("api/v1/tier")
@RestController
public class TireListController {
    public final TireService tireService;

    public TireListController(TireService tireService) {
        this.tireService = tireService;
    }

    @PostMapping
    public ResponseEntity<TireDto> createTireList(@Validated @NonNull @RequestBody CreateTireDto createTireDto) {
        TireDto savedTire = tireService.createTire(createTireDto);
        return new ResponseEntity<>(savedTire, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<TireDto>> getAllTire() {
        List<TireDto> tires = tireService.getAllTires();
        return ResponseEntity.ok(tires);
    }
    @GetMapping("{tid}")
    public ResponseEntity<TireDto> getTireById(@PathVariable("tid") Long tid) {
        TireDto tire = tireService.getTireById(tid);
        return ResponseEntity.ok(tire);
    }
    @PostMapping("row/{rid}/{iid}")
    public ResponseEntity<TireDto> addItemToRow(@PathVariable("rid") Long rid, @PathVariable("iid") Long iid) {
        TireDto tire = tireService.addItemToRow(rid, iid);
        return ResponseEntity.ok(tire);
    }
    @DeleteMapping("row/{rid}/{iid}")
    public ResponseEntity<TireDto> removeItemToRow(@PathVariable("rid") Long rid, @PathVariable("iid") Long iid) {
        TireDto tire = tireService.removeItemFromRow(rid, iid);
        return ResponseEntity.ok(tire);
    }
    @PostMapping("holder/{tid}/{iid}")
    public ResponseEntity<TireDto> addItemToHolder(@PathVariable("tid") Long tid, @PathVariable("iid") Long iid) {
        TireDto tire = tireService.addItemToHolder(tid, iid);
        return ResponseEntity.ok(tire);
    }
    @DeleteMapping("holder/{tid}/{iid}")
    public ResponseEntity<TireDto> removeItemToHolder(@PathVariable("tid") Long tid, @PathVariable("iid") Long iid) {
        TireDto tire = tireService.removeItemFromHolder(tid, iid);
        return ResponseEntity.ok(tire);
    }
}
