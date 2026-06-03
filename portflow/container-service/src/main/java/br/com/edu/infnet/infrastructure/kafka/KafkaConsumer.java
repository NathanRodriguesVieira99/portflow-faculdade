package br.com.edu.infnet.infrastructure.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import br.com.edu.infnet.presentation.events.ContainerStatusEvent;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {
  @KafkaListener(topics = "portflow.container.documentacao_liberada")
  public void receberDocumentacaoLiberada(ContainerStatusEvent event) {
    System.out.println("Evento recebido!");
    System.out.println(event);
  }

  @KafkaListener(topics = "portflow.container.documentacao_recusada")
  public void receberDocumentacaoRecusada(ContainerStatusEvent event) {
    System.out.println("Evento recusado!");
    System.out.println(event);
  }
}
