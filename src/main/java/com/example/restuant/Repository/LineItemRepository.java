package com.example.restuant.Repository;

import com.example.restuant.DTOs.LineItemDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LineItemRepository extends JpaRepository<LineItemDTO, Long> {
    List<LineItemDTO> findByOrderId(String orderId);
}
