package it.epicode.lezione_jwt.repository;

import it.epicode.lezione_jwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
