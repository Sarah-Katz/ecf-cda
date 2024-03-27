package co.simplon.sarah.api.ecf.persistance.repository.bed;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.sarah.api.ecf.persistance.entity.Bed;

public interface IBedRepository extends JpaRepository<Bed, Integer> {
}
