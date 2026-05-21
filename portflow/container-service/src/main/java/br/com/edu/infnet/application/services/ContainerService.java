package br.com.edu.infnet.application.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.edu.infnet.domain.enums.StatusContainer;
import br.com.edu.infnet.domain.models.PortContainer;
import br.com.edu.infnet.infrastructure.repositories.PortContainerRepository;
import br.com.edu.infnet.presentation.dtos.ContainerArrivalRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContainerService {
  private final PortContainerRepository repo;

  public PortContainer registerArrival(ContainerArrivalRequest request) {
    PortContainer container = new PortContainer(
        request.containerId(),
        request.shipId(),
        request.terminalId(),
        request.originCountry(),
        request.destinationCountry(),
        request.cargoType(),
        StatusContainer.CHEGOU,
        LocalDateTime.now());

    return repo.save(container);
  }

  public List<PortContainer> findAll() {
    return repo.findAll();
  }

  public PortContainer findById(String id) {
    return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Container não localizado"));
  }

  public StatusContainer findStatusById(String containerId) {
    return findById(containerId).getStatus();
  }

  public PortContainer updateStatus(String containerId, StatusContainer newStatus) {
    PortContainer container = findById(containerId);
    container.setStatus(newStatus);
    return repo.save(container);
  }

}
