package com.sia.assignment.repository;

import com.sia.assignment.domain.Aoi;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AoiRepository extends JpaRepository<Aoi, Long> {


    @Query(value = "select a.aoi_id, a.name, a.area "+
            "from Aoi as a " +
            "left join Region as r " +
            "on st_intersects(a.area, r.area) " +
            "where r.region_id = :regionId", nativeQuery = true)
    List<Aoi> findAoiListInRegion(@Param("regionId") Long regionId);


    @Query(value = "select a.aoi_id, a.name, a.area "+
        "from aoi as a " +
        "order by st_distance(a.area, :point, true) asc " +
        "limit 1", nativeQuery = true)
    Aoi findNearestAoiInCoordinates(@Param("point") Point point);
}
