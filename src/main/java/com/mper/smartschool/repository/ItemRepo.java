package com.mper.smartschool.repository;

import com.mper.smartschool.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepo extends JpaRepository<Item, Long> {
    Optional<Item> findByName(String name);

}
