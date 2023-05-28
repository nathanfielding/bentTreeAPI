package dev.nwf.bentTreeAPI.service;

import dev.nwf.bentTreeAPI.repository.TenantRepository;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import dev.nwf.bentTreeAPI.model.Apartment;
import dev.nwf.bentTreeAPI.model.Tenant;

@Service
public class TenantService {
    private final TenantRepository tenantRepository;
    private final ApartmentService apartmentService;

    public TenantService(TenantRepository tenantRepository, ApartmentService apartmentService) {
        this.tenantRepository = tenantRepository;
        this.apartmentService = apartmentService;
    }

    public List<Tenant> findAll() {
        return this.tenantRepository.findAll();
    }

    public Tenant findByName(String name) {
        return this.tenantRepository.findByName(name);
    }

    public List<Tenant> findAllByApartmentNumber(String number) {
        Apartment apartment = this.apartmentService.findByNumber(number);
        if (apartment == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Apartment not found");
        }
        return apartment.getTenants();
    }

    public void save(Tenant tenant) {
        this.tenantRepository.save(tenant);
    }
}
