package com.finance.app.reports.infrastructure.persistence.jpa;

import com.finance.app.reports.domain.model.entities.Cartera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends JpaRepository<Cartera, Long>{
    boolean existsById(Long id);
}
