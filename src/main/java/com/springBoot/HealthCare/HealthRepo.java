package com.springBoot.HealthCare;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthRepo extends JpaRepository<CredentialModel, Integer>{

	CredentialModel findByUsername(String username);

}
