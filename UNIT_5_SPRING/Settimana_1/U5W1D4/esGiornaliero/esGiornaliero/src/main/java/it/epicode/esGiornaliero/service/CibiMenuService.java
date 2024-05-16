package it.epicode.esGiornaliero.service;

import it.epicode.esGiornaliero.bean.CibiMenu;
import it.epicode.esGiornaliero.repository.CibiMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CibiMenuService {
    @Autowired
    private CibiMenuRepository cibiMenuRepository;

    public void inserisciCibo (CibiMenu cibo) {
        cibiMenuRepository.save(cibo);
    }
}
