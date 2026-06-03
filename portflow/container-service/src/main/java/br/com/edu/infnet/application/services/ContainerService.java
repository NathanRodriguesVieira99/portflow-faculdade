package br.com.edu.infnet.application.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.edu.infnet.domain.enums.StatusContainer;
import br.com.edu.infnet.domain.models.PortContainer;
import br.com.edu.infnet.infrastructure.kafka.KafkaProducer;
import br.com.edu.infnet.infrastructure.repositories.PortContainerRepository;
import br.com.edu.infnet.presentation.dtos.ContainerArrivalRequest;
import br.com.edu.infnet.presentation.dtos.TerminalValidationResponse;
import br.com.edu.infnet.shared.exceptions.TerminalValidationException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContainerService {
  private final PortContainerRepository repo;
  private final TerminalService terminalService;
  private final KafkaProducer kafka;

  public PortContainer registerArrival(ContainerArrivalRequest request) {
    PortContainer container = new PortContainer(
        request.containerId(),
        request.shipId(),
        request.terminalId(),
        request.originCountry(),
        request.destinationCountry(),
        request.cargoType(),
        StatusContainer.DOCUMENTACAO_PENDENTE,
        LocalDateTime.now());

    TerminalValidationResponse validation = terminalService.validarTerminal(request.terminalId(), request.cargoType());

    if (!validation.terminalValido()) {
      throw new TerminalValidationException(validation.mensagem());
    }

    PortContainer savedContainer = repo.save(container);

    kafka.sendDocumentacaoPendente(savedContainer.getId());

    return savedContainer;
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
