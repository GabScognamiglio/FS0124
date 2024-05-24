package it.epicode.gestione_dispositivi.repository;

import it.epicode.gestione_dispositivi.model.Dispositivo;
import it.epicode.gestione_dispositivi.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartphoneRepository extends JpaRepository<Smartphone, Integer> {
}
