package dev.nwf.bentTreeAPI.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.nwf.bentTreeAPI.service.ApartmentService;
import dev.nwf.bentTreeAPI.service.TenantApartmentLeaseService;
import dev.nwf.bentTreeAPI.model.Apartment;
import dev.nwf.bentTreeAPI.model.Tenant;

@RestController
@RequestMapping("api/apartments")
public class ApartmentController {
    private final ApartmentService apartmentService;
    private final TenantApartmentLeaseService tenantApartmentLeaseService;

    public ApartmentController(ApartmentService apartmentService, TenantApartmentLeaseService tenantApartmentLeaseService) {
        this.apartmentService = apartmentService;
        this.tenantApartmentLeaseService = tenantApartmentLeaseService;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Apartment> findAll() {
        return this.apartmentService.findAll();
    }

    @GetMapping("/number/{number}")
    @ResponseStatus(HttpStatus.OK)
    public Apartment findByNumber(@PathVariable String number) {
        return this.apartmentService.findByNumber(number);
    }

    @GetMapping("/end_date/{endDate}")
    @ResponseStatus(HttpStatus.OK)
    public List<Apartment> findApartmentsByEndDate(@PathVariable String endDate) {
        return this.tenantApartmentLeaseService.findApartmentsByEndDate(endDate);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void createApartment(@RequestBody Apartment apartment) {
        this.apartmentService.save(apartment);
    }

    @PutMapping("/number/{number}/name/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addTenantToApartment(@PathVariable String number, @PathVariable String name) {
        this.tenantApartmentLeaseService.addTenantToApartment(number, name);
    }

    // this method is stil throwing a 500 error
    @PutMapping("/number/{number}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addTenantToApartment(@PathVariable String number, @RequestBody Tenant tenant) {
        this.tenantApartmentLeaseService.addTenantToApartment(number, tenant);
    }

    @DeleteMapping("/number/{number}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByNumber(@PathVariable String number) {
        this.apartmentService.deleteByNumber(number);
    }
}
