package co.simplon.sarah.api.ecf.persistance.repository.service;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.sarah.api.ecf.persistance.entity.Service;

public interface IServiceRepository extends JpaRepository<Service, Integer> {
}
