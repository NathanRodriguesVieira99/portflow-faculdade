package br.com.edu.infnet.presentation.dtos;

import java.util.List;

import br.com.edu.infnet.domain.models.Capacidade;
import br.com.edu.infnet.domain.models.Restricao;
import br.com.edu.infnet.domain.models.Terminal;
import br.com.edu.infnet.domain.models.Zona;

public record TerminalResponse(
    String terminalId,
    String nome,
    boolean ativo,
    List<String> tiposCargaAceitos,
    Capacidade capacidade,
    List<Zona> zonas,
    Restricao restricoes,
    List<String> equipamentos) {

  public static TerminalResponse fromDomain(Terminal terminal) {
    return new TerminalResponse(
        terminal.getTerminalId(),
        terminal.getNome(),
        terminal.isAtivo(),
        terminal.getTiposCargaAceitos(),
        terminal.getCapacidade(),
        terminal.getZonas(),
        terminal.getRestricoes(),
        terminal.getEquipamentos());
  }
}
