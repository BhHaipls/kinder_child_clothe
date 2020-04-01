package com.mper.smartschool.repository;

import com.mper.smartschool.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface DeliveryRepo extends JpaRepository<Delivery,Long> {

    Optional<Delivery> findByName(String name);
}
