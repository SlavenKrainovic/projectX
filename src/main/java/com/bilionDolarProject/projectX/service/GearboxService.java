package com.bilionDolarProject.projectX.service;

import com.bilionDolarProject.projectX.entity.Gearbox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GearboxService {
    private final GearboxRepository gearboxRepository;

    @Autowired
    public GearboxService(GearboxRepository gearboxRepository) {
        this.gearboxRepository = gearboxRepository;
    }

    public List<Gearbox> getGearbox(){
        return gearboxRepository.findAll();
    }





}
