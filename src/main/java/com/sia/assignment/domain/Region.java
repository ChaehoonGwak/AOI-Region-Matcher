package com.sia.assignment.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.locationtech.jts.geom.Polygon;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Getter @Setter
@Entity
public class Region {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Polygon area;

    @Builder
    public Region(String name, Polygon area){
        this.name = name;
        this.area = area;
    }
}
