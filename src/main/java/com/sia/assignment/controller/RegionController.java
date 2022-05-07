package com.sia.assignment.controller;

import com.sia.assignment.domain.Aoi;
import com.sia.assignment.domain.Region;
import com.sia.assignment.dto.AreaRequestDto;
import com.sia.assignment.dto.AreaResponseDto;
import com.sia.assignment.service.RegionService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


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

    @GetMapping("/regions/{regionId}/aois/intersects")
    public ResponseEntity<?> getAoiInRegion(@PathVariable Long regionId){
        List<AreaResponseDto> aoiInRegionList = regionService.intersectRegionAndAoi(regionId);

        if(aoiInRegionList.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(aoiInRegionList);
    }

    @GetMapping("/regions")
    public ResponseEntity<?> getRegion(){
        Region region = regionService.getRegion();
        if(region == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(region);
    }

}
