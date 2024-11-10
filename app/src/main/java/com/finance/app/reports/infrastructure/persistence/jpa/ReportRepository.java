package com.finance.app.reports.infrastructure.persistence.jpa;

import com.finance.app.reports.domain.model.aggregates.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReportRepository extends JpaRepository<Reporte, Long> {
    boolean existsById(Long id);
    Optional<Reporte> findById(Long id);
}
