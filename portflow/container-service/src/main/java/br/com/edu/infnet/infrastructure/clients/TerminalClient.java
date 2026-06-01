package br.com.edu.infnet.infrastructure.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.edu.infnet.presentation.dtos.TerminalValidationResponse;

@FeignClient(name = "${api.endpoints.terminal}")
public interface TerminalClient {
  @GetMapping("/terminais/{terminalId}/validacao")
  TerminalValidationResponse validarTerminal(
      @PathVariable("terminalId") String terminalId,
      @RequestParam("tipoCarga") String tipoCarga);
}
