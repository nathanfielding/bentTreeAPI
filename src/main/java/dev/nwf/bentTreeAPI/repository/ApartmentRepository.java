package dev.nwf.bentTreeAPI.repository;

import dev.nwf.bentTreeAPI.model.Apartment;
import org.springframework.data.repository.ListCrudRepository;

public interface ApartmentRepository extends ListCrudRepository<Apartment, Integer> {
    
    public Apartment findByNumber(String number);
}