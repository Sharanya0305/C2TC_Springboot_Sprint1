package com.tnsif.mall1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tnsif.mall1.entity.Mall;

public interface MallRepository extends JpaRepository<Mall, Long> {
    
}
