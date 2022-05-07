package com.sia.assignment.service;

import com.sia.assignment.domain.Aoi;
import com.sia.assignment.domain.Region;
import com.sia.assignment.dto.AreaRequestDto;
import com.sia.assignment.repository.AoiRepository;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class AoiService {
    private final AoiRepository aoiRepository;

    public void saveAoi(AreaRequestDto requestDto) throws ParseException {
        Polygon area= (Polygon)wktToGeometry(requestDto.getArea());

        Aoi aoi = Aoi.builder()
                .name(requestDto.getName())
                .area(area)
                .build();

        aoiRepository.save(aoi);
    }

    private Geometry wktToGeometry(String wellKnownText) throws ParseException {
        WKTReader fromText = new WKTReader();
        Geometry geom = null;
        geom = fromText.read(wellKnownText);
        System.out.println(geom);
        System.out.println(geom.getClass());
        return geom;
    }
}
