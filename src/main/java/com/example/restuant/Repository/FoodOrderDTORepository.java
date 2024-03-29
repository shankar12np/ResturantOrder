package com.example.restuant.Repository;

import com.example.restuant.DTOs.FoodOrderDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodOrderDTORepository extends JpaRepository<FoodOrderDTO, Long> {
    FoodOrderDTO findByOrderId(String orderId);
}
