package com.bilionDolarProject.projectX.repo;

import com.bilionDolarProject.projectX.entity.PreSetGearbox;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PreSetGearboxRepository extends JpaRepository <PreSetGearbox, Long>{

           PreSetGearbox findPreSetGearboxById(Long id);


}

