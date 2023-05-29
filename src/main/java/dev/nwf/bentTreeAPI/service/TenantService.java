package dev.nwf.bentTreeAPI.service;

import dev.nwf.bentTreeAPI.repository.TenantRepository;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.nwf.bentTreeAPI.model.Tenant;

@Service
public class TenantService {
    private final TenantRepository tenantRepository;

    public TenantService(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    public List<Tenant> findAll() {
        return this.tenantRepository.findAll();
    }

    public Tenant findByName(String name) {
        return this.tenantRepository.findByName(name);
    }

    public void save(Tenant tenant) {
        this.tenantRepository.save(tenant);
    }
}
