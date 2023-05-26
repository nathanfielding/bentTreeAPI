package dev.nwf.bentTreeAPI.repository;

import dev.nwf.bentTreeAPI.model.Tenant;
// import java.util.List;
import org.springframework.data.repository.ListCrudRepository;

public interface TenantRepository extends ListCrudRepository<Tenant, Integer> {
    
    public Tenant findByName(String name);

    // public List<Tenant> findByApartmentNumber(Integer number);
}
