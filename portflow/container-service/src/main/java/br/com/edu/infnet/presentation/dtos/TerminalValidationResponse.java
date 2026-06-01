package br.com.edu.infnet.presentation.dtos;

public record TerminalValidationResponse(
    String terminalId,
    boolean existe,
    boolean ativo,
    boolean tipoCargaAceito,
    boolean capacidadeDisponivel,
    boolean terminalValido,
    String mensagem) {
}
