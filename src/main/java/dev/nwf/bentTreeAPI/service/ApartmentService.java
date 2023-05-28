package dev.nwf.bentTreeAPI.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import dev.nwf.bentTreeAPI.model.Apartment;
import dev.nwf.bentTreeAPI.model.Tenant;
import dev.nwf.bentTreeAPI.repository.ApartmentRepository;
import dev.nwf.bentTreeAPI.repository.TenantRepository;

@Service
public class ApartmentService {
   private final ApartmentRepository apartmentRepository;

    public ApartmentService(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    public List<Apartment> findAll() {
        return this.apartmentRepository.findAll();
    }

    public Apartment findByNumber(String number) {
        return this.apartmentRepository.findByNumber(number);
    }

    public void save(Apartment apartment) {
        this.apartmentRepository.save(apartment);
    }

    public void addTenant(String number, String name) {
        Apartment apartment = this.apartmentRepository.findByNumber(number);
        if (apartment == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Apartment not found");
        }
        // apartment.addTenant(tenant);
        this.apartmentRepository.save(apartment);
    }
}
