package com.empresa.erp.repositories;

import com.empresa.erp.enums.Papel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PapelRepository extends JpaRepository<Papel, Long> {
    Optional<Papel> findByNome(String nome);
}