package com.sia.assignment.controller;

import com.sia.assignment.domain.Region;
import com.sia.assignment.dto.AreaRequestDto;
import com.sia.assignment.service.RegionService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class RegionController {
    private final RegionService regionService;

//    @PostMapping("/regions")
//    public ResponseEntity<?> saveRegion(@RequestBody AreaRequestDto requestDto) throws ParseException {
//        regionService.saveRegion(requestDto);
//        return new ResponseEntity<Region>(HttpStatus.OK);
//    }

    @PostMapping("/regions")
    public void saveRegion(@RequestBody AreaRequestDto requestDto) throws ParseException {
        regionService.saveRegion(requestDto);
    }

    @GetMapping("/regions")
    public void getRegion(){
        regionService.getRegion();
    }

}
