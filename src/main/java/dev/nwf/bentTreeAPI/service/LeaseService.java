package dev.nwf.bentTreeAPI.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.nwf.bentTreeAPI.model.Lease;
import dev.nwf.bentTreeAPI.repository.LeaseRepository;

@Service
public class LeaseService {
    private final LeaseRepository leaseRepository;

    public LeaseService(LeaseRepository leaseRepository) {
        this.leaseRepository = leaseRepository;
    }

    public List<Lease> findAll() {
        return this.leaseRepository.findAll();
    }

    public List<Lease> findAllByEnd_date(Date end_date) {
        return this.leaseRepository.findAllByEnd_date(end_date);
    }

    public void save(Lease lease) {
        this.leaseRepository.save(lease);
    }
}
