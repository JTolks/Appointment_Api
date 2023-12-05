package com.alinanails.project.controller;

import com.alinanails.project.model.Master;
import com.alinanails.project.service.MasterService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/master")
public class MasterController {

    private final MasterService masterService;

    public MasterController(MasterService masterService) {
        this.masterService = masterService;
    }

    @GetMapping("hello")
    public String sayHelloToNewMaster() {
        return "Welcome new master";
    }

    @GetMapping("{id}")
    public Master getMasterById(@PathVariable("id") Long id) {
        return masterService.getMasterById(id);
    }

    @GetMapping("all")
    public Iterable<Master> getAllMastersFromDb() {
        return masterService.getAllMasters();
    }

    @PostMapping
    public Master createNewMaster(@Valid @RequestBody Master master) {
        return masterService.createNewMaster(master);
    }

    @PutMapping("{id}")
    public Optional<Master> updateUser(@PathVariable("id") Long id, @RequestBody Master master) {
        return masterService.modifyMasterById(id, master);
    }

    @DeleteMapping("{id}")
    public void deleteMaster(@PathVariable("id") Long id) {
        masterService.deleteMasterById(id);
    }
}
