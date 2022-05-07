package com.sia.assignment.controller;


import com.sia.assignment.dto.AreaRequestDto;
import com.sia.assignment.service.AoiService;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.io.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AoiConrtoller {
    private final AoiService aoiService;

    @PostMapping("/aois")
    public ResponseEntity<?> saveAoi(@RequestBody AreaRequestDto requestDto) throws ParseException {
        Long aoiId;
        try{
            aoiId = aoiService.saveAoi(requestDto);
        } catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Long>(aoiId, HttpStatus.OK);
    }
}
