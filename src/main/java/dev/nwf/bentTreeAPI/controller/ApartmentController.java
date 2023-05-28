package dev.nwf.bentTreeAPI.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.nwf.bentTreeAPI.service.ApartmentService;
import dev.nwf.bentTreeAPI.model.Apartment;
import dev.nwf.bentTreeAPI.model.Tenant;

@RestController
@RequestMapping("api/apartments")
public class ApartmentController {
    private final ApartmentService apartmentService;

    public ApartmentController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
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

    // currently not working
    @PutMapping("/number/{number}/name/{name}")
    public void addTenant(@PathVariable String number, @PathVariable String name) {
        this.apartmentService.addTenant(number, name);
    }
}
