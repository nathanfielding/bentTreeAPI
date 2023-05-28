package dev.nwf.bentTreeAPI.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "leases")
public class Lease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date start_date;
    private Date end_date;

    @OneToOne
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenant;

    @ManyToOne
    @JoinColumn(name = "apartment_id", nullable = false)
    private Apartment apartment;
    private Integer monthly_rent;
    private Integer deposit;

    public Lease() {
    }

    public Lease(Integer id, Date start_date, Date end_date, Tenant tenant, Apartment apartment, Integer monthly_rent,
            Integer deposit) {
        this.id = id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.tenant = tenant;
        this.apartment = apartment;
        this.monthly_rent = monthly_rent;
        this.deposit = deposit;
    }

    public Integer getId() {
        return this.id;
    }

    public Date getStart_date() {
        return this.start_date;
    }

    public Date getEnd_date() {
        return this.end_date;
    }

    public Tenant getTenant() {
        return this.tenant;
    }

    public Apartment getApartment() {
        return this.apartment;
    }

    public Integer getMonthly_rent() {
        return this.monthly_rent;
    }

    public Integer getDeposit() {
        return this.deposit;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public void setMonthly_rent(Integer monthly_rent) {
        this.monthly_rent = monthly_rent;
    }

    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }
}
