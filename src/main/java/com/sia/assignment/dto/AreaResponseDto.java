package com.sia.assignment.dto;

import lombok.*;

@NoArgsConstructor
@Getter
public class AreaResponseDto {

    private Long id;

    private String name;

    private String area;

    @Builder
    public AreaResponseDto(Long id, String name, String area){
        this.id = id;
        this.name = name;
        this.area = area;
    }
}
