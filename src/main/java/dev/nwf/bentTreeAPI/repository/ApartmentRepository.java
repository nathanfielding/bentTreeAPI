package dev.nwf.bentTreeAPI.repository;

import dev.nwf.bentTreeAPI.model.Apartment;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

public interface ApartmentRepository extends ListCrudRepository<Apartment, Integer> {
    
    public Apartment findByNumber(String number);

    public List<Apartment> findAllByBedrooms(int bedrooms);

    public List<Apartment> findAllByProperty(String property);
}