package com.bilionDolarProject.projectX.service;


import com.bilionDolarProject.projectX.entity.Gearbox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GearboxRepository extends JpaRepository<Gearbox, Long> {
    @Query("SELECT * FROM HONDA")
    Optional<Gearbox> findGearboxById(int id);





}
