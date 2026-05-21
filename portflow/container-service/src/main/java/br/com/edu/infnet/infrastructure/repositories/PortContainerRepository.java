package br.com.edu.infnet.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.edu.infnet.domain.models.PortContainer;

public interface PortContainerRepository extends JpaRepository<PortContainer, String> {

}
