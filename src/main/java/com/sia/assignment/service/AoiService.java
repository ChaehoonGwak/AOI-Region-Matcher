package com.sia.assignment.service;

import com.sia.assignment.domain.Aoi;
import com.sia.assignment.dto.AreaRequestDto;
import com.sia.assignment.dto.AreaResponseDto;
import com.sia.assignment.repository.AoiRepository;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.*;
import org.locationtech.jts.io.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.sia.assignment.common.TypeConversion.createPoint;
import static com.sia.assignment.common.TypeConversion.wktToGeometry;

@Transactional
@RequiredArgsConstructor
@Service
public class AoiService {
    private final AoiRepository aoiRepository;

    public Long saveAoi(AreaRequestDto requestDto) throws ParseException {
        Polygon area= (Polygon)wktToGeometry(requestDto.getArea());

        Aoi aoi = Aoi.builder()
                .name(requestDto.getName())
                .area(area)
                .build();

        aoiRepository.save(aoi);
        return aoi.getId();
    }

    public AreaResponseDto getNearestAoi(double lat, double lng){
        Point point = createPoint(lat, lng);

        Aoi aoi = aoiRepository.findNearestAoiInCoordinates(point);

        AreaResponseDto areaResponseDto = AreaResponseDto.builder()
                .id(aoi.getId())
                .name(aoi.getName())
                .area(aoi.getArea().toString())
                .build();

        return areaResponseDto;
    }

}
