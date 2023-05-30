package dev.nwf.bentTreeAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tenants")
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String phone_number;
    private Boolean is_renewing;
    private String home_address;

    @ManyToOne
    @JoinColumn(name = "apartment_id", referencedColumnName = "id")
    private Apartment apartment;

    @OneToOne(mappedBy = "tenant")
    private Lease lease;

    public Tenant() {
    }

    public Tenant(Integer id, String name, String email, String phone_number, Boolean is_renewing,
            String home_address, Apartment apartment, Lease lease) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
        this.is_renewing = is_renewing;
        this.home_address = home_address;
        this.apartment = apartment;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone_number() {
        return this.phone_number;
    }

    public Boolean getIs_renewing() {
        return this.is_renewing;
    }

    public String getHome_address() {
        return this.home_address;
    }

    public Apartment getApartment() {
        return this.apartment;
    }

    public Lease getLease() {
        return this.lease;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email.toLowerCase();
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setIs_renewing(Boolean is_renewing) {
        this.is_renewing = is_renewing;
    }

    public void setHome_address(String home_address) {
        this.home_address = home_address;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public void setLease(Lease lease) {
        this.lease = lease;
    }
}
