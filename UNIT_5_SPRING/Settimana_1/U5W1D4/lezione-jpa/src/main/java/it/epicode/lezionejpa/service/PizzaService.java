package it.epicode.lezionejpa.service;

import it.epicode.lezionejpa.bean.Pizza;
import it.epicode.lezionejpa.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;

    public void inserisciPizza(Pizza pizza) {
        pizzaRepository.save(pizza);
    }

    public Pizza getPizza(int idPizza) {
        return pizzaRepository.findById(idPizza).get();
    }

    public List<Pizza> getAllPizze() {
        return pizzaRepository.findAll();
    }

    public void cancellaPizza(int id) {
        pizzaRepository.deleteById(id);
    }
}
