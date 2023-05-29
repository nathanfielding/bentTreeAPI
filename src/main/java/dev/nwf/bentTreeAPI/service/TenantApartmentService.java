package dev.nwf.bentTreeAPI.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import dev.nwf.bentTreeAPI.model.Apartment;
import dev.nwf.bentTreeAPI.model.Tenant;

@Service
public class TenantApartmentService {
    private final TenantService tenantService;
    private final ApartmentService apartmentService;

    public TenantApartmentService(TenantService tenantService, ApartmentService apartmentService) {
        this.tenantService = tenantService;
        this.apartmentService = apartmentService;
    }

    public List<Tenant> findAllByApartmentNumber(String number) {
        Apartment apartment = this.apartmentService.findByNumber(number);
        if (apartment == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Apartment not found");
        }
        return apartment.getTenants();
    }

    public void addTenantToApartment(String number, String name) {
        Apartment apartment = this.apartmentService.findByNumber(number);
        if (apartment == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Apartment not found");
        }
        Tenant tenant = this.tenantService.findByName(name);
        if (tenant == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tenant not found");
        }
        apartment.addTenant(tenant);
        tenant.setApartment(apartment);

        this.apartmentService.save(apartment);
        this.tenantService.save(tenant);
    }

    public void addTenantToApartment(String number, Tenant tenant) {
        Apartment apartment = this.apartmentService.findByNumber(number);
        if (apartment == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Apartment not found");
        }
        if (this.tenantService.findByName(tenant.getName()) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tenant not found");
        }
        apartment.addTenant(tenant);
        tenant.setApartment(apartment);
        
        this.apartmentService.save(apartment);
        this.tenantService.save(tenant);
    }
}
