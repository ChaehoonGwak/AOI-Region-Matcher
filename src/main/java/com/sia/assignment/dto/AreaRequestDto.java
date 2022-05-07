package com.sia.assignment.dto;

import lombok.*;

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
}
