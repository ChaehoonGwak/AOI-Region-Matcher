package com.sia.assignment.domain;

import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Polygon;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter @Setter
@Entity
public class PolygonEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Polygon polygon;

}