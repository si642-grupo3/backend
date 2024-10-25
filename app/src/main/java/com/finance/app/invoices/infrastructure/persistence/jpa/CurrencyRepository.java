package com.finance.app.invoices.infrastructure.persistence.jpa;

import com.finance.app.invoices.domain.model.entities.Moneda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Moneda, Long> {

}
