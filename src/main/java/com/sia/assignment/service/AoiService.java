package com.sia.assignment.service;

import com.sia.assignment.domain.Aoi;
import com.sia.assignment.dto.AreaRequestDto;
import com.sia.assignment.repository.AoiRepository;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.io.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


}
