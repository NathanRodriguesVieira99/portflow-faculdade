package br.com.edu.infnet.shared.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.edu.infnet.presentation.dtos.ErrorResponse;
import br.com.edu.infnet.shared.exceptions.TerminalValidationException;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(TerminalValidationException.class)
  public ResponseEntity<ErrorResponse> handleTerminalValidationException(TerminalValidationException ex,
      HttpServletRequest req) {
    ErrorResponse terminalInvalido = new ErrorResponse("TERMINAL INVÁLIDO", ex.getMessage());
    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(terminalInvalido);
  }
}
