package br.com.edu.infnet.presentation.dtos;

public record ValidacaoTerminalResponse(
    String terminalId,
    Boolean existe,
    Boolean ativo,
    Boolean tipoCargaAceito,
    Boolean capacidadeDisponivel,
    Boolean terminalValido,
    String mensagem) {
}
