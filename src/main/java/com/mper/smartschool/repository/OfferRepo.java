package com.mper.smartschool.repository;

import com.mper.smartschool.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepo extends JpaRepository<Offer,Long> {
}
