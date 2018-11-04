package ua.logos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.logos.entity.ManufacturerEntity;

@Repository
public interface ManufacturerRepository extends JpaRepository<ManufacturerEntity, Long> {
}
