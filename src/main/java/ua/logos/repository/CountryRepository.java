package ua.logos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.logos.entity.CountryEntity;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
}
