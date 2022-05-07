package com.sia.assignment.domain;

import lombok.*;
import org.locationtech.jts.geom.Polygon;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Region {

    @Id
    @Column(name = "region_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(columnDefinition = "Geometry")
    private Polygon area;

    @Builder
    public Region(String name, Polygon area){
        this.name = name;
        this.area = area;
    }
}
