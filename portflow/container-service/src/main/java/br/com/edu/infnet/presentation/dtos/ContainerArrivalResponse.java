package br.com.edu.infnet.presentation.dtos;

import java.time.LocalDateTime;

import br.com.edu.infnet.domain.enums.StatusContainer;
import br.com.edu.infnet.domain.models.PortContainer;

public record ContainerArrivalResponse(String containerId,
    String shipId,
    String terminalId,
    String originCountry,
    String destinationCountry,
    String cargoType, StatusContainer status, LocalDateTime arrivalDate) {
  public static ContainerArrivalResponse fromDomain(PortContainer container) {
    return new ContainerArrivalResponse(
        container.getId(),
        container.getShipId(),
        container.getTerminalId(),
        container.getOriginCountry(),
        container.getDestinationCountry(),
        container.getCargoType(),
        container.getStatus(),
        container.getArrivalDate());
  }
}
