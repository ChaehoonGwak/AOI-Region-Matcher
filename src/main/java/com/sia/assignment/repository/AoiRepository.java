package com.sia.assignment.repository;

import com.sia.assignment.domain.Aoi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AoiRepository extends JpaRepository<Aoi, Long> {
}