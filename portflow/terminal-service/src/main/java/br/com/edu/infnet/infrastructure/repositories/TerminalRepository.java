package br.com.edu.infnet.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.edu.infnet.domain.models.Terminal;

public interface TerminalRepository extends MongoRepository<Terminal, String> {
  Optional<Terminal> findByTerminalId(String s);
}
