package br.com.edu.infnet.presentation.dtos;

public record ContainerArrivalRequest(
    String containerId,
    String shipId,
    String terminalId,
    String originCountry,
    String destinationCountry,
    String cargoType) {
}
