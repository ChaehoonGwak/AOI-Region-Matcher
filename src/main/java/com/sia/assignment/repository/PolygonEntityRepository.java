package com.sia.assignment.repository;

import com.sia.assignment.domain.PolygonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolygonEntityRepository extends JpaRepository<PolygonEntity, Long> {
}
