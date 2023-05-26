package dev.nwf.bentTreeAPI.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import dev.nwf.bentTreeAPI.repository.ApartmentRepository;
import dev.nwf.bentTreeAPI.repository.TenantRepository;
import dev.nwf.bentTreeAPI.model.Apartment;
import dev.nwf.bentTreeAPI.model.Tenant;

import java.util.List;

@RestController
@RequestMapping("api/tenants")
public class TenantController {
    private final TenantRepository tenantRepository;
    private final ApartmentRepository apartmentRepository;

    public TenantController(TenantRepository tenantRepository, ApartmentRepository apartmentRepository) {
        this.tenantRepository = tenantRepository;
        this.apartmentRepository = apartmentRepository;
    }

    @GetMapping("")
    public List<Tenant> findAll() {
        return this.tenantRepository.findAll();
    }

    @GetMapping("/name/{name}")
    public Tenant findByName(@PathVariable String name) {
        return this.tenantRepository.findByName(name);
    }

    @GetMapping("/apartment/{number}")
    public List<Tenant> findByApartmentNumber(@PathVariable String number) {
        Apartment apartment = this.apartmentRepository.findByNumber(number);
        if (apartment == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Apartment not found");
        }
        return apartment.getTenants();
    }

    @PostMapping("")
    public void createTenant(@RequestBody Tenant tenant) {
        this.tenantRepository.save(tenant);
    }
}
