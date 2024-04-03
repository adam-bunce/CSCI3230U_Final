package com.webdev.project.service;

import com.webdev.project.model.ProvidedService;
import com.webdev.project.repo.ProvidedServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvidedServiceService {
    ProvidedServiceRepo serviceRepo;

    @Autowired
    public ProvidedServiceService(ProvidedServiceRepo serviceRepo) {
        super();
        this.serviceRepo = serviceRepo;
    }

    public ProvidedService saveOrUpdateService(ProvidedService service) {
        return this.serviceRepo.save(service);
    }

    public List<ProvidedService> getAllServices() {
        return this.serviceRepo.findAll();
    }

    public void deleteByServiceId(Long id) {
        this.serviceRepo.deleteById(id);
    }
    public ProvidedService getServiceById(Long id) {
        return this.serviceRepo.getReferenceById(id);
    }
}
