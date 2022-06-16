package de.kebidge.hft.dpt.ccbackend;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CcBackendUserRepository extends JpaRepository<CcBackendUserEntity, Long>  {
    
}
