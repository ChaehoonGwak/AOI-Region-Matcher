package com.sia.assignment.dto;


import com.sia.assignment.domain.Region;
import lombok.*;
import org.locationtech.jts.geom.Polygon;

@NoArgsConstructor
@Getter
public class AreaRequestDto {

    private String name;

    private String area;

    @Builder
    public AreaRequestDto(String name, String area){
        this.name = name;
        this.area = area;
    }

    public Region toEntity(Polygon polygon){
        return Region.builder()
                .name(name)
                .area(polygon)
                .build();
    }
}
