package ua.logos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.logos.entity.AdvertEntity;

public interface AdvertRepository extends JpaRepository<AdvertEntity, Long> {
}
