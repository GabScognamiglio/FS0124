package it.epicode.gestione_dispositivi.repository;

import it.epicode.gestione_dispositivi.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<Laptop, Integer> {
}
