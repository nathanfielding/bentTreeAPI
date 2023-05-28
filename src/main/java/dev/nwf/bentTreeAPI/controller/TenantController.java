package dev.nwf.bentTreeAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.nwf.bentTreeAPI.service.TenantService;
import dev.nwf.bentTreeAPI.model.Tenant;

import java.util.List;

@RestController
@RequestMapping("api/tenants")
public class TenantController {
    private final TenantService tenantService;

    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @GetMapping("")
    public List<Tenant> findAll() {
        return this.tenantService.findAll();
    }

    @GetMapping("/name/{name}")
    public Tenant findByName(@PathVariable String name) {
        return this.tenantService.findByName(name);
    }

    @GetMapping("/apartment/{number}")
    public List<Tenant> findByApartmentNumber(@PathVariable String number) {
        return this.tenantService.findAllByApartmentNumber(number);
    }

    @PostMapping("")
    public void createTenant(@RequestBody Tenant tenant) {
        this.tenantService.save(tenant);
    }
}
