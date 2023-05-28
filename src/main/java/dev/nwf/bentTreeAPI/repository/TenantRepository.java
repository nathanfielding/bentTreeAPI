package dev.nwf.bentTreeAPI.repository;

import dev.nwf.bentTreeAPI.model.Tenant;
import org.springframework.data.repository.ListCrudRepository;

public interface TenantRepository extends ListCrudRepository<Tenant, Integer> {
    
    public Tenant findByName(String name);
}
