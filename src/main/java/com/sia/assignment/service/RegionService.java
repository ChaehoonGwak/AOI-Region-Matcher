package com.sia.assignment.service;


import com.sia.assignment.domain.Region;
import com.sia.assignment.dto.AreaRequestDto;
import com.sia.assignment.repository.RegionRepository;
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
public class RegionService {
    private final RegionRepository regionRepository;

    public void getRegion(){
        Region region = regionRepository.getById(2L);

        System.out.println(region.getId());
        System.out.println(region.getName());
        System.out.println(region.getArea());
    }

    public void saveRegion(AreaRequestDto requestDto) throws ParseException {
        Polygon area = (Polygon)wktToGeometry(requestDto.getArea());

        Region region = Region.builder()
                .name(requestDto.getName())
                .area(area)
                .build();

        regionRepository.save(region);
    }

//    public void registerRegion(String name, String area) throws ParseException {
//        Polygon polygon = (Polygon) wktToGeometry(area);
//
//        Region region = Region.builder()
//                .name(name)
//                .area(polygon)
//                .build();
//
//        regionRepository.save(region);
////        return true;
//    }

    private Geometry wktToGeometry(String wellKnownText) throws ParseException {
        WKTReader fromText = new WKTReader();
        Geometry geom = null;
        geom = fromText.read(wellKnownText);
        System.out.println(geom);
        System.out.println(geom.getClass());
        return geom;
    }

}
