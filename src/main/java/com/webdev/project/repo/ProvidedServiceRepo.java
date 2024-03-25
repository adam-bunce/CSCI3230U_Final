package com.webdev.project.repo;

import com.webdev.project.model.ProvidedService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvidedServiceRepo extends JpaRepository<ProvidedService, Long> {
}
