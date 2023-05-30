package dev.nwf.bentTreeAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.nwf.bentTreeAPI.service.LeaseService;
import dev.nwf.bentTreeAPI.service.TenantApartmentLeaseService;
import dev.nwf.bentTreeAPI.model.Lease;

import java.util.List;

@RestController
@RequestMapping("api/leases")
public class LeaseController {
    private final LeaseService leaseService;
    private final TenantApartmentLeaseService tenantApartmentService;
    
    public LeaseController(LeaseService leaseService, TenantApartmentLeaseService tenantApartmentService) {
        this.leaseService = leaseService;
        this.tenantApartmentService = tenantApartmentService;
    }

    @GetMapping("")
    public List<Lease> findAll() {
        return this.leaseService.findAll();
    }

    @GetMapping("/name/{name}")
    public Lease findByTenantName(@PathVariable String name) {
        return this.tenantApartmentService.findLeaseByTenantName(name);
    }

    @PostMapping("")
    public void addLease(@RequestBody Lease lease) {
        this.leaseService.save(lease);
    }

    // need to add option for PUT request to assign tenant to lease or vice versa
}
