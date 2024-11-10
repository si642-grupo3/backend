package com.finance.app.users.infrastructure.persistance.jpa;
import com.finance.app.users.domain.model.aggregates.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Cliente, Long>{
    boolean existsById(Long id);
    Optional<Cliente> findByEmailAndPassword(String email, String password);
    Optional<Cliente> findById(Long id);
}
