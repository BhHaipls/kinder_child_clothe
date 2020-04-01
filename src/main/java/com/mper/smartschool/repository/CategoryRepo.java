package com.mper.smartschool.repository;


import com.mper.smartschool.entity.Category;
import com.mper.smartschool.entity.modelsEnum.SexStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);
    Collection<Category> findAllBySex(SexStatus sex);
}
