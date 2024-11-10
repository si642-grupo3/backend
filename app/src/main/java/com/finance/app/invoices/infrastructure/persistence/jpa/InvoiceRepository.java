package com.finance.app.invoices.infrastructure.persistence.jpa;

import com.finance.app.invoices.domain.model.aggregates.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface InvoiceRepository extends JpaRepository<Factura, Long> {

    boolean existsByNumero(String numero);
    Optional<Factura> findById(Long id);
}
