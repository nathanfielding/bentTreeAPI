package dev.nwf.bentTreeAPI.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.nwf.bentTreeAPI.service.LeaseService;
import dev.nwf.bentTreeAPI.service.TenantApartmentLeaseService;
import dev.nwf.bentTreeAPI.model.Lease;

import java.util.List;

@RestController
@RequestMapping("api/leases")
public class LeaseController {
    private final LeaseService leaseService;
    private final TenantApartmentLeaseService tenantApartmentLeaseService;
    
    public LeaseController(LeaseService leaseService, TenantApartmentLeaseService tenantApartmentLeaseService) {
        this.leaseService = leaseService;
        this.tenantApartmentLeaseService = tenantApartmentLeaseService;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Lease> findAll() {
        return this.leaseService.findAll();
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Lease findByTenantName(@PathVariable String name) {
        return this.tenantApartmentLeaseService.findLeaseByTenantName(name);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void createLease(@RequestBody Lease lease) {
        this.leaseService.save(lease);
    }

    // tricky to do since leases don't have an outstanding identifier to query by
    // like name for Tenant or number for Apartment
    @PutMapping("/name/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void assignTenantToLease(String name) {
        
    }
}
