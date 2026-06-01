package br.com.edu.infnet.infrastructure.clients;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/* CORRIGIR ERRO */
@SpringBootTest
public class TerminalClientTest {
  @Autowired
  private TerminalClient feing;

  @Test
  void shouldTestClient() {
    feing.validarTerminal("T1", "ELETRONICOS");
  }
}
