package br.com.edu.infnet.application.services;

import org.springframework.stereotype.Service;

import br.com.edu.infnet.infrastructure.clients.TerminalClient;
import br.com.edu.infnet.presentation.dtos.TerminalValidationResponse;
import br.com.edu.infnet.shared.exceptions.TerminalValidationException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TerminalService {
  private final TerminalClient feing;

  @CircuitBreaker(name = "terminalValidation", fallbackMethod = "fallBackMethod")
  @Retry(name = "terminalValidation")
  public TerminalValidationResponse validarTerminal(String terminalId, String cargoType) {
    return feing.validarTerminal(terminalId, cargoType);
  }

  public TerminalValidationResponse fallBackMethod(String terminalId, String cargoType, Throwable tw) {
    System.out.println("Fall Back Executado!");
    throw new TerminalValidationException("Não foi possivel validar o terminal par a a carga " + cargoType);

  }

}
