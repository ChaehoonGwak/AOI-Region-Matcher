package com.sia.assignment.controller;



import com.sia.assignment.dto.AreaRequestDto;
import com.sia.assignment.dto.AreaResponseDto;
import com.sia.assignment.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/regions")
public class RegionController {
    private final RegionService regionService;

    @PostMapping
    public ResponseEntity<?> saveRegion(@RequestBody AreaRequestDto requestDto){
        Long regionId;

        try{
            regionId = regionService.saveRegion(requestDto);
        } catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Long>(regionId, HttpStatus.OK);
    }

    @GetMapping("/{regionId}/aois/intersects")
    public ResponseEntity<?> getAoiInRegion(@PathVariable Long regionId){
        List<AreaResponseDto> aoiInRegionList;

        try{
            aoiInRegionList = regionService.intersectRegionAndAoi(regionId);
        } catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<List<AreaResponseDto>>(aoiInRegionList, HttpStatus.OK);
    }

    @GetMapping("/{regionId}")
    public ResponseEntity<?> getRegion(@PathVariable Long regionId){
        AreaResponseDto areaResponseDto;

        try{
            areaResponseDto = regionService.getRegion(regionId);
        } catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<AreaResponseDto>(areaResponseDto, HttpStatus.OK);
    }

}
