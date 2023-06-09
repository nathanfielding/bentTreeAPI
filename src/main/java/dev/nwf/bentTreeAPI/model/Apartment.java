package dev.nwf.bentTreeAPI.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "apartments")
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String number;
    @Size(min = 1, max = 4)
    private Integer occupancy;
    @Size(min = 1, max = 4)
    private Integer bedrooms;
    @NotBlank
    private String property;
    
    @JsonIgnore
    @OneToMany(mappedBy = "apartment")
    private List<Tenant> tenants = new ArrayList<>();

    public Apartment() {
    }

    public Apartment(Integer id, String number, Integer occupancy, Integer bedrooms, String property) {
        this.id = id;
        this.number = number;
        this.occupancy = occupancy;
        this.bedrooms = bedrooms;
        this.property = property;
    }

    public Integer getId() {
        return this.id;
    }

    public String getNumber() {
        return this.number;
    }

    public Integer getOccupancy() {
        return this.occupancy;
    }

    public Integer getBedrooms() {
        return this.bedrooms;
    }

    public String getProperty() {
        return this.property;
    }

    public List<Tenant> getTenants() {
        return this.tenants;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setOccupancy(Integer occupancy) {
        this.occupancy = occupancy;
    }

    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public void setTenants(List<Tenant> tenants) {
        this.tenants = tenants;
    }

    public void addTenant(Tenant tenant) {
        this.tenants.add(tenant);
    }
}
