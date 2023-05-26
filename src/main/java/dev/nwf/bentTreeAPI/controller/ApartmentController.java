package dev.nwf.bentTreeAPI.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.nwf.bentTreeAPI.repository.ApartmentRepository;
import dev.nwf.bentTreeAPI.model.Apartment;

@RestController
@RequestMapping("api/apartments")
public class ApartmentController {
    private final ApartmentRepository apartmentRepository;

    public ApartmentController(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    @GetMapping("")
    public List<Apartment> findAll() {
        return this.apartmentRepository.findAll();
    }

    @PostMapping(value = "", consumes = "application/json")
    public void createApartment(@RequestBody Apartment apartment) {
        this.apartmentRepository.save(apartment);
    }
}
