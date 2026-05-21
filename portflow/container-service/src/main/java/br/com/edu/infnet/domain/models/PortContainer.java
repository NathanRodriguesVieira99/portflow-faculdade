package br.com.edu.infnet.domain.models;

import java.time.LocalDateTime;

import br.com.edu.infnet.domain.enums.StatusContainer;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "containers", schema = "container_service")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
public class PortContainer {
  @Id
  private String id;
  private String shipId;
  private String terminalId;
  private String originCountry;
  private String destinationCountry;
  private String cargoType;
  @Enumerated(EnumType.STRING)
  private StatusContainer status;
  private LocalDateTime arrivalDate;
}
