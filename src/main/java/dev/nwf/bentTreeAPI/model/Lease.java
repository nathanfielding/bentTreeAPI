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
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.PastOrPresent;

@Entity
@Table(name = "leases")
public class Lease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @PastOrPresent
    private Date startDate;
    @Future
    private Date endDate;

    @OneToOne
    @JoinColumn(name = "tenant_id", referencedColumnName = "id")
    private Tenant tenant;

    @ManyToOne
    @JoinColumn(name = "apartment_id", referencedColumnName = "id")
    private Apartment apartment;
    private Integer monthly_rent;
    private Integer deposit;

    public Lease() {
    }

    public Lease(Integer id, Date startDate, Date endDate, Tenant tenant, Apartment apartment, Integer monthly_rent,
            Integer deposit) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tenant = tenant;
        this.apartment = apartment;
        this.monthly_rent = monthly_rent;
        this.deposit = deposit;
    }

    public Integer getId() {
        return this.id;
    }

    public Date getstartDate() {
        return this.startDate;
    }

    public Date getEndDate() {
        return this.endDate;
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

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setendDate(Date endDate) {
        this.endDate = endDate;
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
