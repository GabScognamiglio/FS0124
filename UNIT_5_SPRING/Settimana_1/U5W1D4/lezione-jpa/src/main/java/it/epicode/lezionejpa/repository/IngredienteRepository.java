package it.epicode.lezionejpa.repository;

import it.epicode.lezionejpa.bean.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {
}
