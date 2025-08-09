package com.tnsif.mall1.repository; // Changed package name

import org.springframework.data.jpa.repository.JpaRepository;
import com.tnsif.mall1.entity.Mall; // Changed import

public interface MallRepository extends JpaRepository<Mall, Long> { // Interface name remains 'MallRepository'
}
