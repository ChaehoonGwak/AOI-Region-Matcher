package com.sia.assignment.repository;

import com.sia.assignment.domain.PointEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PointEntityRepository extends JpaRepository<PointEntity, Long> {
}
