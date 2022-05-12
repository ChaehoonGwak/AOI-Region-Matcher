package com.sia.assignment.service;


import com.sia.assignment.domain.Aoi;
import com.sia.assignment.domain.Region;
import com.sia.assignment.dto.AreaRequestDto;
import com.sia.assignment.dto.AreaResponseDto;
import com.sia.assignment.repository.AoiRepository;
import com.sia.assignment.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.io.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.sia.assignment.common.TypeConversion.wktToGeometry;

@Transactional
@RequiredArgsConstructor
@Service
public class RegionService {
    private final RegionRepository regionRepository;
    private final AoiRepository aoiRepository;

    public AreaResponseDto getRegion(Long regionId){
        Region region = regionRepository.getById(regionId);

        AreaResponseDto areaResponseDto = AreaResponseDto.builder()
                .id(region.getId())
                .name(region.getName())
                .area(region.getArea().toString())
                .build();

        return areaResponseDto;
    }

    public Long saveRegion(AreaRequestDto requestDto) throws ParseException {
        Polygon area = (Polygon)wktToGeometry(requestDto.getArea());

        Region region = Region.builder()
                .name(requestDto.getName())
                .area(area)
                .build();

        regionRepository.save(region);
        return region.getId();
    }

    public List<AreaResponseDto> intersectRegionAndAoi(Long regionId){
        Optional<Region> region = regionRepository.findById(regionId);

        System.out.println(region);
        List<Aoi> aoiInRegionList = new ArrayList<>();

        if(region == null){
            return null;
        }
        else{
            aoiInRegionList = aoiRepository.findAoiListInRegion(regionId);
            List<AreaResponseDto> areaResponseDtoList = new ArrayList<>();

            for (Aoi aoi: aoiInRegionList){
                AreaResponseDto areaResponseDto = AreaResponseDto.builder()
                        .id(aoi.getId())
                        .name(aoi.getName())
                        .area(aoi.getArea().toString())
                        .build();
                areaResponseDtoList.add(areaResponseDto);
            }

            return areaResponseDtoList;
        }
    }

}
