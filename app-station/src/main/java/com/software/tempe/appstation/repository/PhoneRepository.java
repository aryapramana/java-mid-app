package com.software.tempe.appstation.repository;

import com.software.tempe.appstation.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Integer> {
    // JpaRepository already implement @Repository
}
