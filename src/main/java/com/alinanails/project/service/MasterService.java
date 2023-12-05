package com.alinanails.project.service;

import com.alinanails.project.model.Master;
import com.alinanails.project.repository.MasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MasterService {

    private final MasterRepository masterRepository;

    @Autowired
    public MasterService(MasterRepository masterRepository) {
        this.masterRepository = masterRepository;
    }

    public String sayHello() {
        return "Hello new Master";
    }

    public Master getMasterById(Long id) {
        return masterRepository.findById(id)
                .filter(master -> master.getMasterId().equals(id))
                .orElseThrow(() -> new IllegalStateException("Master by this id " + id + " not found"));
    }

    public Master createNewMaster(Master master) {
        return masterRepository.save(master);
    }

    public Iterable<Master> getAllMasters() {
        return masterRepository.findAll();

    }

    public void deleteMasterById(Long id) {
        masterRepository.deleteById(id);
    }

    public Optional<Master> modifyMasterById(Long id, Master master) {
        return masterRepository.findById(id)
                .filter(m ->
                        m.getMasterId().equals(id))
                .map(master1 -> {
                    master1.setMasterName(master.getMasterName());
                    master1.setSpeciality(master.getSpeciality());
                    return masterRepository.save(master1);
                });
    }

}
