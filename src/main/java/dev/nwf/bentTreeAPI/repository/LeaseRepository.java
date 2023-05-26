package dev.nwf.bentTreeAPI.repository;

import dev.nwf.bentTreeAPI.model.Lease;
import org.springframework.data.repository.ListCrudRepository;

public interface LeaseRepository extends ListCrudRepository<Lease, Integer> {
    
}
