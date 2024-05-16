package it.epicode.lezionejpa.service;

import it.epicode.lezionejpa.bean.CibiMenu;
import it.epicode.lezionejpa.bean.Pizza;
import it.epicode.lezionejpa.repository.CibiMenuRepository;
import it.epicode.lezionejpa.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CibiMenuService {
    @Autowired
    private CibiMenuRepository cibiMenuRepository;

    public void inserisciPizza(CibiMenu cibo) {
        cibiMenuRepository.save(cibo);
    }

    public CibiMenu getCibiMenu(int idCibiMenu) {
        return cibiMenuRepository.findById(idCibiMenu).get();
    }

    public List<CibiMenu> getAllCibi() {
        return cibiMenuRepository.findAll();
    }

    public void cancellaCibiMenu(int id) {
        cibiMenuRepository.deleteById(id);
    }
}
