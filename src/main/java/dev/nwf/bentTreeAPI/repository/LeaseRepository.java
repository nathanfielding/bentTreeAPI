package dev.nwf.bentTreeAPI.repository;

import dev.nwf.bentTreeAPI.model.Lease;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

public interface LeaseRepository extends ListCrudRepository<Lease, Integer> {

    public List<Lease> findAllByEnd_date(Date end_date);
}
