package dev.nwf.bentTreeAPI.service;

import org.springframework.stereotype.Service;

import dev.nwf.bentTreeAPI.model.Apartment;
import dev.nwf.bentTreeAPI.repository.ApartmentRepository;

@Service
public class ApartmentService {
   private final ApartmentRepository apartmentRepository;

    public ApartmentService(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    public Apartment findByNumber(String number) {
        return this.apartmentRepository.findByNumber(number);
    }
}
