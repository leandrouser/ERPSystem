package com.empresa.erp.repositories;

import com.empresa.erp.models.SaleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<SaleModel, Long> {
}