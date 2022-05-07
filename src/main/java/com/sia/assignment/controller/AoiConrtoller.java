package com.sia.assignment.controller;


import com.sia.assignment.dto.AreaRequestDto;
import com.sia.assignment.service.AoiService;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.io.ParseException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AoiConrtoller {
    private final AoiService aoiService;

    @PostMapping("/aois")
    public void saveAoi(@RequestBody AreaRequestDto requestDto) throws ParseException {
        aoiService.saveAoi(requestDto);
    }
}
