package cybersecurity.project.repository;

import cybersecurity.project.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    
}
