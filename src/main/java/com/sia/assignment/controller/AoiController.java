package com.sia.assignment.controller;


import com.sia.assignment.dto.AreaRequestDto;
import com.sia.assignment.dto.AreaResponseDto;
import com.sia.assignment.service.AoiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/aois")
public class AoiController {
    private final AoiService aoiService;

    @PostMapping
    public ResponseEntity<?> saveAoi(@RequestBody AreaRequestDto requestDto){
        Long aoiId;

        try{
            aoiId = aoiService.saveAoi(requestDto);
        } catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Long>(aoiId, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getNearestAoi(@RequestParam("lat") double lat, @RequestParam("long") double lng){
        AreaResponseDto areaResponseDto;

        try{
            areaResponseDto = aoiService.getNearestAoi(lat, lng);
        } catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<AreaResponseDto>(areaResponseDto, HttpStatus.OK);

    }

}
