package dev.nwf.bentTreeAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.nwf.bentTreeAPI.repository.LeaseRepository;
import dev.nwf.bentTreeAPI.model.Lease;

import java.util.List;

@RestController
@RequestMapping("api/leases")
public class LeaseController {
    private final LeaseRepository leaseRepository;
    
    public LeaseController(LeaseRepository leaseRepository) {
        this.leaseRepository = leaseRepository;
    }

    @GetMapping("")
    public List<Lease> findAll() {
        return this.leaseRepository.findAll();
    }
}
