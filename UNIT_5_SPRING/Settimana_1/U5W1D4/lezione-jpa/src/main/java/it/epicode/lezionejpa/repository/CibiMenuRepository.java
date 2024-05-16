package it.epicode.lezionejpa.repository;

import it.epicode.lezionejpa.bean.CibiMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract interface CibiMenuRepository extends JpaRepository<CibiMenu, Integer> {

}
