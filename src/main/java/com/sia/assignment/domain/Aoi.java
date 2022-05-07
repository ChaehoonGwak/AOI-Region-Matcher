package com.sia.assignment.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.locationtech.jts.geom.Polygon;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Aoi {

    @Id
    @Column(name = "aoi_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(columnDefinition = "Geometry")
    private Polygon area;

    @Builder
    public Aoi(String name, Polygon area){
        this.name = name;
        this.area = area;
    }
}
