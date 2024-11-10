package com.finance.app.finalCosts.infrastructure.persistence.jpa;

import com.finance.app.finalCosts.domain.model.aggregates.CosteFinal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinalCostRepository extends JpaRepository<CosteFinal, Long> {

}
