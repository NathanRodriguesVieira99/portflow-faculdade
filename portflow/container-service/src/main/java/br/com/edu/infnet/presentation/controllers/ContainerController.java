package br.com.edu.infnet.presentation.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edu.infnet.application.services.ContainerService;
import br.com.edu.infnet.domain.models.PortContainer;
import br.com.edu.infnet.presentation.dtos.ContainerArrivalRequest;
import br.com.edu.infnet.presentation.dtos.ContainerArrivalResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/containers")
@RequiredArgsConstructor
public class ContainerController {
  private final ContainerService service;

  @PostMapping("/arrival")
  public ResponseEntity<ContainerArrivalResponse> registerArrival(@RequestBody ContainerArrivalRequest request) {
    PortContainer container = service.registerArrival(request);
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(ContainerArrivalResponse.fromDomain(container));
  }

  @GetMapping
  public ResponseEntity<List<ContainerArrivalResponse>> findAll() {
    List<ContainerArrivalResponse> containers = service.findAll().stream()
        .map(ContainerArrivalResponse::fromDomain)
        .toList();
    return ResponseEntity.ok(containers);
  }

  @GetMapping("{containerId}")
  public ResponseEntity<ContainerArrivalResponse> findById(@PathVariable(name = "containerId") String containerId) {
    PortContainer container = service.findById(containerId);
    return ResponseEntity.ok(ContainerArrivalResponse.fromDomain(container));
  }
}
