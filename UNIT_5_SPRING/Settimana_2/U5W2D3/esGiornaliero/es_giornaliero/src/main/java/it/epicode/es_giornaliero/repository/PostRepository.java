package it.epicode.es_giornaliero.repository;

import it.epicode.es_giornaliero.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
