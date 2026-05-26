package br.com.edu.infnet.presentation.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.edu.infnet.application.services.TerminalService;
import br.com.edu.infnet.presentation.dtos.TerminalResponse;
import br.com.edu.infnet.presentation.dtos.ValidacaoTerminalResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("terminais")
@RequiredArgsConstructor
public class TerminalController {
  private final TerminalService terminalService;

  @GetMapping
  public ResponseEntity<Iterable<TerminalResponse>> findAll() {
    Iterable<TerminalResponse> response = terminalService.findAll()
        .stream()
        .map(TerminalResponse::fromDomain)
        .toList();

    return ResponseEntity.ok(response);
  }

  @GetMapping("/{terminalId}")
  public ResponseEntity<TerminalResponse> findByTerminalId(
      @PathVariable("terminalId") String terminalId) {
    return ResponseEntity.ok(
        TerminalResponse.fromDomain(
            terminalService.findByTerminalId(terminalId)));
  }

  @GetMapping("/{terminalId}/validacao")
  public ResponseEntity<ValidacaoTerminalResponse> validarTerminal(
      @PathVariable("terminalId") String terminalId,
      @RequestParam("tipoCarga") String tipoCarga) {
    return ResponseEntity.ok(
        terminalService.validarTerminal(terminalId, tipoCarga));
  }

}
