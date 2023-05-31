package dev.nwf.bentTreeAPI.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.nwf.bentTreeAPI.service.TenantApartmentLeaseService;
import dev.nwf.bentTreeAPI.service.TenantService;
import dev.nwf.bentTreeAPI.model.Tenant;

import java.util.List;

@RestController
@RequestMapping("api/tenants")
public class TenantController {
    private final TenantService tenantService;
    private final TenantApartmentLeaseService tenantApartmentLeaseService;

    public TenantController(TenantService tenantService, TenantApartmentLeaseService tenantApartmentLeaseService) {
        this.tenantService = tenantService;
        this.tenantApartmentLeaseService = tenantApartmentLeaseService;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Tenant> findAll() {
        return this.tenantService.findAll();
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Tenant findByName(@PathVariable String name) {
        return this.tenantService.findByName(name);
    }

    @GetMapping("/apartment/{number}")
    @ResponseStatus(HttpStatus.OK)
    public List<Tenant> findByApartmentNumber(@PathVariable String number) {
        return this.tenantApartmentLeaseService.findAllByApartmentNumber(number);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTenant(@RequestBody Tenant tenant) {
        this.tenantService.save(tenant);
    }
}
