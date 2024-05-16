package it.epicode.lezionejpa.repository;

import it.epicode.lezionejpa.bean.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract interface PizzaRepository extends JpaRepository<Pizza, Integer> {
}
