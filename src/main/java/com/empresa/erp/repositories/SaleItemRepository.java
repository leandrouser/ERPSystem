package com.empresa.erp.repositories;

import com.empresa.erp.models.SaleItemModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleItemRepository extends JpaRepository<SaleItemModel, Long> {
}