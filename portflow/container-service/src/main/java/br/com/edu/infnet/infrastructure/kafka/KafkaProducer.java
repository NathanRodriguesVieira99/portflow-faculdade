package br.com.edu.infnet.infrastructure.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.com.edu.infnet.presentation.events.ContainerStatusEvent;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KafkaProducer {
  private final KafkaTemplate<String, ContainerStatusEvent> kafka;

  private void sendEvent(ContainerStatusEvent event) {
    kafka.send("portflow.container.documentacao_pendente", event.containerId(), event);
  }

  public void sendDocumentacaoPendente(String containerId) {
    ContainerStatusEvent containerStatusEvent = ContainerStatusEvent.documentacaoPendente(containerId);
    sendEvent(containerStatusEvent);
  }
}
