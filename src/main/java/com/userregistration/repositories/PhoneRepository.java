package com.userregistration.repositories;

import com.userregistration.entities.Phone;
import com.userregistration.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, String>{
}


