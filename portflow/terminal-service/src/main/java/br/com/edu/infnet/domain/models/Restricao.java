package br.com.edu.infnet.domain.models;

public class Restricao {
  private boolean aceitaCargaPerigosa;

  private boolean aceitaCargaRefrigerada;

  private Double alturaMaximaMetros;

  private Double pesoMaximoToneladas;

  public boolean isAceitaCargaPerigosa() {
    return aceitaCargaPerigosa;
  }

  public boolean isAceitaCargaRefrigerada() {
    return aceitaCargaRefrigerada;
  }

  public Double getAlturaMaximaMetros() {
    return alturaMaximaMetros;
  }

  public Double getPesoMaximoToneladas() {
    return pesoMaximoToneladas;
  }
}
