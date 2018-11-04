package ua.logos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.logos.entity.CityEntity;

public interface CityRepository extends JpaRepository<CityEntity, Long> {
}
