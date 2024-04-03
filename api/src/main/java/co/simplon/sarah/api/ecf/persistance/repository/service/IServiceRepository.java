package co.simplon.sarah.api.ecf.persistance.repository.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.sarah.api.ecf.persistance.entity.Service;

@Repository
public interface IServiceRepository extends JpaRepository<Service, Integer> {
}
