package com.sia.assignment.repository;

import com.sia.assignment.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface RegionRepository extends JpaRepository<Region, Long> {
}
