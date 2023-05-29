package dev.nwf.bentTreeAPI.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.nwf.bentTreeAPI.service.ApartmentService;
import dev.nwf.bentTreeAPI.service.TenantApartmentService;
import dev.nwf.bentTreeAPI.model.Apartment;
import dev.nwf.bentTreeAPI.model.Tenant;

@RestController
@RequestMapping("api/apartments")
public class ApartmentController {
    private final ApartmentService apartmentService;
    private final TenantApartmentService tenantApartmentService;

    public ApartmentController(ApartmentService apartmentService, TenantApartmentService tenantApartmentService) {
        this.apartmentService = apartmentService;
        this.tenantApartmentService = tenantApartmentService;
    }

    @GetMapping("")
    public List<Apartment> findAll() {
        return this.apartmentService.findAll();
    }

    @GetMapping("/number/{number}")
    public Apartment findByNumber(@PathVariable String number) {
        return this.apartmentService.findByNumber(number);
    }

    @PostMapping("")
    public void createApartment(@RequestBody Apartment apartment) {
        this.apartmentService.save(apartment);
    }

    @PutMapping("/number/{number}/name/{name}")
    public void addTenantToApartment(@PathVariable String number, @PathVariable String name) {
        this.tenantApartmentService.addTenantToApartment(number, name);
    }

    @PutMapping("/number/{number}")
    public void addTenantToApartment(@PathVariable String number, @RequestBody Tenant tenant) {
        this.tenantApartmentService.addTenantToApartment(number, tenant);
    }

    @DeleteMapping("/number/{number}")
    public void deleteByNumber(@PathVariable String number) {
        this.apartmentService.deleteByNumber(number);
    }
}
