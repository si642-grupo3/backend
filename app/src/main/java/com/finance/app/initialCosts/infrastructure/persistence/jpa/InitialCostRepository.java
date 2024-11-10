package com.finance.app.initialCosts.infrastructure.persistence.jpa;

import com.finance.app.initialCosts.domain.model.aggregates.CosteInicial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InitialCostRepository extends JpaRepository<CosteInicial, Long> {

}
