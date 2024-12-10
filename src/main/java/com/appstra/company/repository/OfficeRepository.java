package com.appstra.company.repository;

import com.appstra.company.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeRepository extends JpaRepository<Office,Integer> {
}
