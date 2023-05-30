package dev.nwf.bentTreeAPI.service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import dev.nwf.bentTreeAPI.model.Apartment;
import dev.nwf.bentTreeAPI.model.Lease;
import dev.nwf.bentTreeAPI.model.Tenant;

@Service
public class TenantApartmentLeaseService {
    private final TenantService tenantService;
    private final ApartmentService apartmentService;
    private final LeaseService leaseService;

    public TenantApartmentLeaseService(TenantService tenantService, ApartmentService apartmentService,
            LeaseService leaseService) {
        this.tenantService = tenantService;
        this.apartmentService = apartmentService;
        this.leaseService = leaseService;
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
        // allows for the possibility for an extra tenant above the occupancy limit
        if (apartment.getTenants().size() > apartment.getOccupancy()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Apartment is full");
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
        if (apartment.getTenants().size() > apartment.getOccupancy()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Apartment is full");
        }
        apartment.addTenant(tenant);
        tenant.setApartment(apartment);

        this.apartmentService.save(apartment);
        this.tenantService.save(tenant);
    }

    public Lease findLeaseByTenantName(String name) {
        Tenant tenant = this.tenantService.findByName(name);
        if (tenant == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tenant not found");
        }
        if (tenant.getLease() == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tenant has no associated lease");
        }
        return tenant.getLease();
    }

    public List<Apartment> findApartmentsByEnd_date(String date) {
        Date end_date = Date.valueOf(date);

        // shorthand version using Java Streams
        return this.leaseService.findAllByEnd_date(end_date).stream()
                .filter(lease -> lease.getApartment() != null)
                .map(Lease::getApartment)
                .collect(Collectors.toList());

    }
}
