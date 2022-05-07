package com.sia.assignment.repository;

import com.sia.assignment.domain.Aoi;
import com.sia.assignment.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface RegionRepository extends JpaRepository<Region, Long> {

}
