package com.bilionDolarProject.projectX.repo;

import com.bilionDolarProject.projectX.entity.PreSetGearbox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PreSetGearboxRepository extends JpaRepository <PreSetGearbox, Long>{

           PreSetGearbox findPreSetGearboxById(Long id);
           
           List<PreSetGearbox> findByCarBrand(String carBrand);

           @Query("SELECT DISTINCT p.carBrand FROM PreSetGearbox p")
           List<String> findAllCarBrands();
}
