package com.bilionDolarProject.projectX.service;

import com.bilionDolarProject.projectX.entity.PreSetGearbox;
import com.bilionDolarProject.projectX.repo.PreSetGearboxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PreSetGearboxService {

    private final PreSetGearboxRepository preSetGearboxRepository;
    @Autowired
    public PreSetGearboxService(PreSetGearboxRepository preSetGearboxRepository) {
        this.preSetGearboxRepository = preSetGearboxRepository;
    }

    public void addNewPreSetGearbox(PreSetGearbox preSetGearbox) {
        preSetGearboxRepository.save(preSetGearbox);
    }

    public List<PreSetGearbox> getPreSetGearbox() {
        return preSetGearboxRepository.findAll();
    }

    public PreSetGearbox findPreSetGearboxById(Long id){
        Optional<PreSetGearbox> preSetGearbox = preSetGearboxRepository.findById(id);
        if(preSetGearbox.isPresent()){
            return preSetGearbox.get();
        }
        throw new IllegalStateException("gearbox with id" + id + "does not exist");
    }

    public List<PreSetGearbox> getGearboxesByCarBrand(String carBrand) {
        return preSetGearboxRepository.findByCarBrand(carBrand);
    }

    public List<String> getAllCarBrands() {
        return preSetGearboxRepository.findAllCarBrands();
    }
}
